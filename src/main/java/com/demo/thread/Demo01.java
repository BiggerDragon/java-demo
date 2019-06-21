package com.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Demo01 {

    public static void main(String[] args) {

        //创建线程的方式有三种
        //1.实现Runnable接口2.继承Thread类3.实现Callable接口

        //1.用Runnable还是Thread？
        //因为java不支持多继承，所以如果你的线程类想要继承别的类，那么就实现Runnable接口
        //2.start()和run()的区别?
        Thread thread = new Thread();
        thread.start();//用来启动创建的新线程,内部调用了run方法
        thread.run();//只是调用了线程对象的run方法，并没有启动线程
        //Thread类也继承了Runnable接口
        //3.Java中Runnable和Callable有什么不同？
        //Runnable和Callable都代表着哪些要在不同线程中执行的任务
        //Runnable有run方法，Callable有call方法
        //Callable的call方法可以返回值和抛出异常，而run方法没有这样的功能
        //Callable还能返回装载有计算结果的Future对象

        //4.Java中CyclicBarrier 和 CountDownLatch有什么不同？
        //都可以让一组线程等待其他线程,与CyclicBarrier不同的是，CountDownLatch不能重新使用

        CyclicBarrier cyclicBarrier;
        CountDownLatch countDownLatch;



    }
}
