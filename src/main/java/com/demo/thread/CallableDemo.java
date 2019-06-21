package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable和Runnable的区别
 * 1.Callable规定call()方法，Runnable规定run方法
 * 2.Callable执行可以返回值，而Runnable不能
 * 3.call()方法可以抛出异常，而run()不会
 * 4.Callable任务可拿到一个Future对象，表示异步的执行结果
 * 5.它还提供了检查计算是否完成，等待完成并检索计算结果的方法
 * 6.通过Future对象可以了解任务的执行情况，可以取消任务的执行，还可以获取任务执行的结果
 *
 */
public class CallableDemo {

    public static void main(String[] args) {

        CallableTask callableTask = new CallableTask();

        //执行Callable需要FutureTask的支持，用于接受返回的结果
        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        new Thread(futureTask).start();

        //接受线程运算后的结果
        try {
            //FutureTask可以用于闭锁,类似于CountDownLatch，在所有线程没有执行完这里是不会执行的
            Integer sum = futureTask.get();
            System.out.println(sum);
            System.out.println("=========================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            String threadName = Thread.currentThread().getName();
            System.out.println("当前线程:"+threadName+"正在执行call方法");
            int sum = 0;
            for (int i = 0; i < 100000; i ++){
                sum++;
            }
            return sum;
        }
    }

}


