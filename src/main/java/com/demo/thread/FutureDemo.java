package com.demo.thread;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {

        //创建了一个可以使用空闲线程的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                String string = "S";
                for (int i = 0 ; i < 1000; i ++){
                    string += i;
                }
                Thread.sleep(3000);
                return string;
            }
        });

        doSomething();


        //返回FutureTask
        //FutureTask是Future的实现类
        System.out.println("Future:" + future.getClass());
        System.out.println("询问任务是否完成:" + future.isDone());
        try {
            //该方法会阻塞至有结果返回
            System.out.println("result:" + future.get());
            System.out.println("再次询问是否完成:"+future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束");

        executorService.shutdown();

    }

    public static void doSomething(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("花了两秒做了一些额外工作");
    }




}
