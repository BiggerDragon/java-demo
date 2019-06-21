package com.demo.util;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        Object array =  Array.newInstance(int.class, 10);
        System.out.println(Array.class.isInstance(array));
        Array.set(array, 0, 10);
        System.out.println(Array.get(array, 0));
        int i = Array.getInt(array, 1);
        System.out.println(i);
        System.out.println(Array.get(array, 9));
        //Array和ArrayList的区别？
        //Array能容纳基本类型和对象，ArrayList只能容纳对象

        ArrayList arrayList = new ArrayList();

        Object array2 = Array.newInstance(Number.class, 10);
        for (int n = 0 ; n < 10 ; n ++){
            if (n % 2 == 0){
                Array.set(array2, n, 12);
            }else if (n % 3 == 0){
                Array.set(array2, n, 43.22);
            }else if (n % 4 == 0){
                Array.set(array2, n, 4.99f);
            }else{
                Array.set(array2, n, Byte.valueOf("1"));
            }
        }
        for (int k = 0 ; k < 10 ; k ++){
            System.out.println(Array.get(array2, k));
        }

    }
}
