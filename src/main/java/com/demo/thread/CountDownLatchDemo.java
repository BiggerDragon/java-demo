package com.demo.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
//        CountDownLatch countDownLatch = new CountDownLatch();
        //1.什么是CountDownLatch?又叫闭锁
        //CountDownLatch能够使一个线程完成其他线程完成各自工作后再执行。
        //CountDownLatch伪代码?
        //Main thread start
        //Create CountDownLatch for N threads
        //Main thread wait on latch
        //N threads completes their tasks are returns
        //Main thread resume execution

        //构造函数
        //表示主线程闭锁需要等待的线程数量为100个
        CountDownLatch countDownLatch = new CountDownLatch(100);

        //主线程必须再启动其他线程之后再调用await()方法
        //这样主线程就会再这个方法上阻塞只到其他线程完成任务

        //N个线程必须引用闭锁对象，因为他们需要在完成任务时调用countDown()来通知闭锁对象任务完成了

        //1.解释一下CountDownLatch概念?
        //能够让一个线程在其他线程完成之后再执行

        //2.CountDownLatch 和CyclicBarrier的不同之处?
        //CountDownLatch计数器只能使用一次，而CyclicBarrier的计数器可以被reset方法重置，重复使用
        //即CountDownLatch只能使用一次，而CyclicBarrier能使用多次
        //都可以让一个或者一组线程来等待其他线程

        //给出一些CountDownLatch使用的例子?
        //CountDownLatch 类中主要的方法?最重要的方法await()和countDown()
        //await使主线程等待直到count为0(它等待的其他线程都完成了任务)
        //countDown()被等待的线程执行完成后调用，count减去1





    }
}
