package com.demo.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        //1.什么时CyclicBarrier?又叫栅栏
        //栅栏类似于闭锁，能让一个线程阻塞至若干个线程都到达栅栏位，才能继续执行
        //CyclicBarrier可以让一定数量的线程反复的再栅栏处汇集，在线程达到栅栏处时调用await方法，
        //该方法阻塞到所有线程都到达栅栏位。如果所有线程都到达，则栅栏位会放开，此时所有的线程都会被释放
        //而栅栏会被重置以便下次使用

        //第一个参数:参与线程的个数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        //第二个参数：最后一个到达的线程要执行的任务
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("最后一个任务...");
            }
        });


    }
}
