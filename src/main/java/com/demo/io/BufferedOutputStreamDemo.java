package com.demo.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/workspace/gradle-demo/out.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            String data = "ThisManIsGood";
            bufferedOutputStream.write(data.getBytes());
//            bufferedOutputStream.write(data.getBytes(), 0, (data.getBytes()).length);

            //一定要执行该语句否则，数据不会写入到文件
            bufferedOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
