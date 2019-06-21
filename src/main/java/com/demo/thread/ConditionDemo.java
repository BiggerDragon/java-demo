package com.demo.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private ReentrantLock lock = new ReentrantLock();

    //不为空，有可消费物品
    private Condition notFull = lock.newCondition();

    //不满，可以继续生产物品
    private Condition notEmpty = lock.newCondition();

    private int QueueSize = 10;

    //共享队列
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws InterruptedException {

        //ConditionObject是AQS内部类
        //Condition:是用来替代传统的Object.wait()和notify()方法的
        //Condition提供await()和sigal()分别对应wait()和notify()
        //比Object的wait()和notify()更加安全和高效
        //Condition是一个接口，具体实现是ConditionObject,它是AQS的一个内部类
        //Condition依赖Lock接口,使用Lock对象的newCondition()来创建一个Condition对象
        //调用Condition的await()和sigal()方法必须在lock.lock()和lock.unlock()之间
        //也就是说在调用Condition的方法之前必须获取到锁
        //Condition中signalAll()对应Object的notifyAll()


        ConditionDemo conditionDemo = new ConditionDemo();
        Producer producer = conditionDemo.new Producer();
        Consumer consumer = conditionDemo.new Consumer();

        producer.start();
        consumer.start();

        Thread.sleep(3000);

        producer.interrupt();
        consumer.interrupt();
    }

    /**
     *
     * Condition实现生产者消费者模式
     *
     */
    private class Producer extends Thread{

        public void run(){
            produce();
        }

        private volatile boolean isIterrupted = false;
        public void produce(){
            if (isIterrupted == false){

                lock.lock();

                try {
                    while (queue.size() == QueueSize){
                        //没有可用空间
                        try {
                            //释放锁，并让当前线程沉睡，等待唤醒
                            System.out.println("队列已满等待可用空间...");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            isIterrupted = true;
                        }
                    }
                    //生产一个物品
                    queue.offer(1);
                    //通知
                    notEmpty.signal();
                    System.out.println("向队列插入元素...");
                }finally {
                    lock.unlock();

                }
            }
        }

    }

    private class Consumer extends Thread{

        private volatile boolean isIterrupted = false;

        public void run(){
            consume();
        }

        public void consume(){
            if (isIterrupted == false){
                lock.lock();
                try {
                    while (queue.size() == 0){
                        System.out.println("队列为空等待，可用物品");
                        try {
                            //释放锁，并让消费者线程进入睡眠状态，等待被唤醒
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            isIterrupted = true;
                        }
                    }
                    //消费一个物品
                    queue.poll();
                    //唤醒生成者线程
                    notFull.signal();
                    System.out.println("消费了一个物品");
                }finally {
                    lock.unlock();
                }
            }
        }

    }


}
