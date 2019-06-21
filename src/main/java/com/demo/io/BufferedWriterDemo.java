package com.demo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("D:\\workspace\\gradle-demo\\out.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "ILOVEHELIXUE";
            char [] chars = data.toCharArray();
            int i = - 1;
            bufferedWriter.write(chars, 0, chars.length);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
