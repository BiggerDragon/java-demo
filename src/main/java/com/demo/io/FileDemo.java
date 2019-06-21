package com.demo.io;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        File file1 = new File("t1.txt");
        if (file1.exists()){
            System.out.println("文件存在");
        }
    }
}
