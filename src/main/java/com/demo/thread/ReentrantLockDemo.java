package com.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {


    public static void main(String[] args) {

        Good good = new Good(100, "Apple");
        Task task = new Task(good);
        Task task1 = new Task(good);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(task);
        executorService.submit(task1);

    }

    private static class Task implements Runnable{

        private Good good;

        public Task(Good good) {
            this.good = good;
        }

        public void run() {
            good.consumeGood();
//            good.showNum();
        }
    }

    private static class Good{

        private int num = 0;
        private String name;

        private ReentrantLock reentrantLock = new ReentrantLock();

        public Good(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public void consumeGood(){
            reentrantLock.lock();
            System.out.println("current thread:"+Thread.currentThread().getName()+"ready to consume good");
            for (int i = 0 ; i < 50 ; i ++){
                if (num > 0){
                    num--;
                }
            }
            showNum();
            reentrantLock.unlock();
        }

        public void showNum(){
//            reentrantLock.lock();
            System.out.println("current thread:"+Thread.currentThread().getName()+this.name +"还剩:" + this.num);
//            reentrantLock.unlock();
        }

    }

}
