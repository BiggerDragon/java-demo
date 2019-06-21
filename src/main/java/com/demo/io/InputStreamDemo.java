package com.demo.io;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class InputStreamDemo{

    public void doDemo(){
//        InputStream inputStream = InputStream.nullInputStream();
        InputStream inputStream = null;
        System.out.println(inputStream);
        byte [] bytes = new byte[10];
        try {
            /**返回可用或者可跳过的字节数，不会阻塞**/
            int i = inputStream.available();
            System.out.println("available bytes:" + i);
            /**读取指定字节数数组长度的字节并返回实际读取的字节数**/
            int j = inputStream.read(bytes);
            System.out.println("read bytes:" + j);
            /**同上**/
            j = inputStream.read(bytes, 0, bytes.length);
            System.out.println("read bytes:" + j);
            System.out.println(bytes.length);

            inputStream = new ByteArrayInputStream("ABC中国人".getBytes());
            System.out.println("available bytes:" + inputStream.available());
//            byte [] allBytes = inputStream.readAllBytes();
//            System.out.println("allBytes length:" + allBytes.length);
//            System.out.println(new String(allBytes));

            /***没有重写mark和reset方法*/
            FileInputStream fis = new FileInputStream("t1.txt");
            /**fis.mark(100);fis.reset();**/
            /**读取一个字节*/
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());

            /***/
            fis.close();
            fis = new FileInputStream("t1.txt");
            FileChannel fileChannel = fis.getChannel();
            /**Channel是NIO范畴**/
            System.out.println(fileChannel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**volatile变量演示多线程下的可见性**/
    public volatile boolean isOver = false;

    public void volatileDemo(){
        /**
         * synchronized和volatile
         * 二者都是多线程下的同步机制
         * 前者是阻塞式同步，线程激烈竞争的情况下会变成重量级锁
         * 后者是java虚拟机提供的轻量级的同步机制
         * java内存模型告诉我们，多线程会将共享变量从主存中拷贝到工作内存中，
         * 然后执行引擎会根据工作内存中的数据进行操作
         * 工作线程在执行操作完后何时写回主存，这对普通的变量是没有规定的，
         * 而对于用volatile修饰的变量而言，一个线程对其进行修改会立即被其他线程
         * 所感知，避免了对数据的脏读，从而保证了数据的可见性。
         *
         * 即：用volatile修饰的变量保证了每个线程能够获取到它的最新值，从而避免了
         * 对数据的脏读。
         * 原理:在生成汇编代码时会在volatile修饰的共享变量进行写操作的时候会多出Lock前缀的指令
         * Lock前缀的指令会引起处理器缓存写回内存；
         * 一个处理器的缓存回写到内存会导致其他处理器的缓存失效；
         * 当处理器发现本地缓存失效后，就会从内存中重读该变量数据，即可以获取当前最新值。
         *
         * */

        /***volatile变量演示**/
        new Thread(()->{
            while (!isOver){
                System.out.println("not over");
            }
            System.out.println("over");
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**主线程修改并写回主存，thread工作线程的变量失效，重新从主存读取，结束死循环**/
        isOver = true;

    }

}
