package com.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * RandomAccessFile实现DataInput和DataOutput两个接口
 * 表示它既可以读也可以写
 * 它可以自由访问文件的任何位置，可以任意读取文件的任何部分内容
 * seek方法将指针一道某个位置开始读或者写
 *
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("./nio-data.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        int bufferRead = fileChannel.read(byteBuffer);
        while (bufferRead != -1){
            System.out.println("bufferRead :" + bufferRead);
            //切换Buffer模式
            //limit is set to currnet position
            //current posotion is set to 0
            //discard mark
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }

            //the current position is set to 0
            //the limit is set to capacity
            //discard the mark
            byteBuffer.clear();

            bufferRead = fileChannel.read(byteBuffer);
        }

        randomAccessFile.close();

    }
}
