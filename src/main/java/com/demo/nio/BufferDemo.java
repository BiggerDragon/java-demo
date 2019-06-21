package com.demo.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer是个抽象类
 *
 *
 */
public class BufferDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("./int-data.txt");

        FileChannel fileChannel = fileInputStream.getChannel();

        System.out.println("fileChannel size:" + fileChannel.size());
        System.out.println("fileChannel position:" + fileChannel.position());

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int readInt = fileChannel.read(byteBuffer);
        while (readInt != -1){
            //ready to get data from byte buffer

            //limit is set to current position
            //position is set to 0
            //discard the mark
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                byte b = byteBuffer.get();
                System.out.println(b);
            }

            //limit is set to capacity
            //position is set to 0
            //discard mark
            byteBuffer.clear();

            readInt = fileChannel.read(byteBuffer);

        }

        fileChannel.close();

    }
}
