package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Questions {
    public static void main(String[] args) {
        //1.Java中有几种流?
        //字节流和姊字符流
        // 字节流InputStream和OutputStream
        // 字符流Reader和Writer

        //2.谈一谈java IO中的常见类,接口，实现类，阻塞
        //输入流就是从文件或者网络等读取数据到内存中
        //输出流就是从内存中将数据写到文件或者网络中
        //字符流中有抽象类Reader Wtiter
        // 实现类有FileReader FileWriter StringReader StringWriter
        // BufferedReader BufferedWriter
        //字节流抽象类InputStream和OutputStream
        //字节流实现类有FileInputStream FileOutputStream ByteArrayInputStream ByteArrayOutputStream
        //ObjectInputStream ObjectOutputStram 等等
        //接口有Closeable Flushable Apendable
        //程序中输入输出都是以流的形式保存的，流中保存的实际上就是字节文件
        //阻塞方法有read readLine


        //键盘作为输入设备
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //什么是IO流?
        //流是对数据从源到目的地的一种抽象，例如文件输入流是对数据从文件流动到内存中的一种抽象
        //什么是Filter流，主要是对已存在的基础流提供额外的功能
        //比如LineNumberInputStream给目标文件提供不存在的行数，或者是提高性能
        //BufferedInputStream可以提高性能


    }

}
