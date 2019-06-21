package com.demo.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        //1.当Queue为空时，获取元素的线程会被阻塞至Queue不为空
        //2.当向Queue添加元素时，添加元素的线程被阻塞到Queue不满
        //3.BlockingQueue不允许有null值，否则抛出NullpointerException
        //入队：add() offer() put()会阻塞， offer()还支持超时机制
        //出队:remove() poll() take()会阻塞, poll()还支持超时机制
        //检查:element() peek();

        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        //一个生产者，两个消费者
        Producer producer =  new Producer(blockingQueue);
        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

        //常用BlockingQueue实现
        //ArrayBlockingQueue:有界的阻塞队列:出入队使用一把锁
        //LinkedBlockingQueue:动态的阻塞队列，出队和入队使用两把锁
        //PriorityBlockingQueue
        //SynchronousQueue


    }

    private static class Producer implements Runnable{

        private BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    //当队列满时生产者阻塞
                    blockingQueue.put(produce());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Object produce(){
            Object object = new Object();
            System.out.println("生产了产品..."+object.hashCode());
            return object;
        }
    }

    private static class Consumer implements Runnable{

        private BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    //当队列为空时消费者阻塞
                    consume(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void consume(Object object){
            System.out.println("消费了产品:"+object + "hashCode=" + object.hashCode());
        }
    }
}
