package com.demo.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\workspace\\gradle-demo\\src\\main\\resources\\t1.txt");
            //对于较大文件使用BufferedInputStream效率更高
            //提供一个缓冲区，读取时首先从缓冲区读取，没有数据才从数据源读取
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            System.out.println(bufferedInputStream.available());
//            byte [] bytes = bufferedInputStream.readAllBytes();
//            System.out.println(new String(bytes));
            bufferedInputStream.close();

            fileInputStream = new FileInputStream("D:\\workspace\\gradle-demo\\src\\main\\resources\\t1.txt");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte [] bytes1 = new byte[10];
            bufferedInputStream.read(bytes1, 0, 5);
            System.out.println("第1-5个字节：" + new String(bytes1));
            bufferedInputStream.mark(6);
            bufferedInputStream.read(bytes1, 0, 5);
            System.out.println("第6-10个字节：" + new String(bytes1));
            bufferedInputStream.reset();
            int c = bufferedInputStream.read();
            System.out.println((char)c);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
