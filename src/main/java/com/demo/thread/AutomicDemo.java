package com.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicDemo {

    //存在线程安全的问题
    private volatile int i = 0;
    //原子类不存在线程安全问题
    private AtomicInteger j = new AtomicInteger(0);
    public static void main(String[] args) {
        //原子类
        AutomicDemo automicDemo = new AutomicDemo();

        for (int i = 0 ; i < 1000; i ++){
            new Thread(automicDemo.new Task()).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终值:" + automicDemo.j);
    }
    private class Task implements Runnable{

        @Override
        public void run() {
            increment();
        }

        public void increment(){
            //不是原子操作
//            i = i + 1;

            //原子操作
            j.getAndAdd(1);
        }

    }

}
