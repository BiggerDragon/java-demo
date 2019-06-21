package com.demo.nio;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws FileNotFoundException {
        File fromFile = new File("./nio-data.txt");
        File toFile = new File("./nio-data1.txt");

        copyFile(fromFile, toFile);
    }

    /**
     *
     * @param fromFile
     * @param toFile
     * @throws FileNotFoundException
     */
    public static void copyFile(File fromFile, File toFile) throws FileNotFoundException {
        FileInputStream fromFileInputStream = new FileInputStream(fromFile);
        FileOutputStream toFileOutputStream = new FileOutputStream(toFile);
        FileChannel fromFileChannel = fromFileInputStream.getChannel();
        FileChannel toFileChannel = toFileOutputStream.getChannel();
        try {
            fromFileChannel.transferTo(0, fromFileChannel.size(), toFileChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fromFileInputStream!=null){
                    fromFileInputStream.close();
                }
                if (fromFileChannel!=null){
                    fromFileChannel.close();
                }
                if (toFileOutputStream!=null){
                    toFileOutputStream.close();
                }
                if (toFileChannel!=null){
                    toFileChannel.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

}



