package com.demo.util;

import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {

        String s = "2";
        String s2 = "32";
        String s3 = "df";

        Object [] objects = {new String("2"), new String("32"), new String("df")};
        System.out.println(objects.length);
        System.out.println(s == objects[0]);
        System.out.println(s2 == objects[1]);
        System.out.println(s3 == objects[2]);


        System.out.println(Arrays.toString(objects));
        Object [] objects1 = Arrays.copyOf(objects, 3);
        System.out.println(Arrays.toString(objects1));
        System.out.println(objects1[0] == objects[0]);
        System.out.println(objects == objects1);
    }
}
