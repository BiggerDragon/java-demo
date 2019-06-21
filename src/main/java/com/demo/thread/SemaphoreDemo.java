package com.demo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo {

    private Semaphore semaphore = new Semaphore(5);

    private int i = 0;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        //1.什么使Semaphore?
        //是synchronized的加强版,可以控制并发量
        //最大支持5个线程
        //Semaphore semaphore = new Semaphore(5);

        //acquire()方法获取许可，判断许可数是否大于0，大于0则获取许可，并将许可数减一
        //否则阻塞至有许可
        //在acquire和release方法之间，同时只能允许指定数的线程进入

        //release()释放许可，将许可数加1


        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int j = 0 ; j < 1000; j ++){
            new Thread(semaphoreDemo.new Task(semaphoreDemo.semaphore)).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Semaphore的acquire和release方法之间不能保证线程安全
        System.out.println("最终i="+semaphoreDemo.i);
        System.out.println("最终atomicInteger="+semaphoreDemo.atomicInteger);


    }

    private class Task implements Runnable{

        private Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                i = i + 1;
                atomicInteger.getAndAdd(1);
                System.out.println("执行任务...");
                System.out.println("可用permits:"+semaphore.availablePermits());

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
