package com.demo.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:\\workspace\\gradle-demo\\t1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            char [] chars = new char[10];
            int i = -1;
            while ((i = bufferedReader.read(chars, 0, chars.length))!=-1){
                System.out.print(new String(chars, 0, i));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
