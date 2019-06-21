package com.demo.util;

import java.util.Arrays;

/**
 * 数组拷贝
 */
public class ArrayDemo02 {

    public static void main(String[] args) {

        //System.arraycopy和Arrays.copyOf的区别?
        //前者只是拷贝原数组的元素到指定的数组，并没有在拷贝是创建新数组
        //后者在拷贝时创建新数组
        int [] ints = new int[10];
        int [] sourceInts = {1,2,3,4,5};
        System.arraycopy(sourceInts, 0, ints,1, 5);
        System.out.println(Arrays.toString(ints));

        int [] newInts = Arrays.copyOf(sourceInts, 4);
        System.out.println(Arrays.toString(newInts));


    }
}
