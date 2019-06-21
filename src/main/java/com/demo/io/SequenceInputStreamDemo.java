package com.demo.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis1 = new FileInputStream("D:\\workspace\\gradle-demo\\t1.txt");
            FileInputStream fis2 = new FileInputStream("D:\\workspace\\gradle-demo\\t2.txt");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(fis1,fis2);
//            byte [] bytes = sequenceInputStream.readAllBytes();
//            System.out.println(new String(bytes));
            fis1.close();
            fis2.close();

            FileInputStream fis3 = new FileInputStream("D:\\workspace\\gradle-demo\\t1.txt");
            FileInputStream fis4 = new FileInputStream("D:\\workspace\\gradle-demo\\t2.txt");
            Vector<InputStream> vector = new Vector<>();
            vector.add(fis3);
            vector.add(fis4);
            Enumeration<InputStream> enumeration = vector.elements();
            SequenceInputStream sequenceInputStream2 = new SequenceInputStream(enumeration);
//            System.out.println(new String(sequenceInputStream2.readAllBytes()));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
