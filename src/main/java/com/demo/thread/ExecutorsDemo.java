package com.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        //线程池
        //Executors提供创建四种线程池的方法
        //1.创建一个可以回收的空闲线程的线程池，如果没有空闲线程，则才创建新线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        //2.创建一个定长的线程池，可控制线程池的并发量，超出线程长度，会在队列中等待空闲线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //3.创建一个定长的线程，可以支持定时及周期性任务的执行
        ExecutorService executorService2 = Executors.newScheduledThreadPool(10);
        //4.创建一个只有一个线程的线程池，所有的任务都使用这一个线程，提交任务按照先进先出的方式执行
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

    }
}
