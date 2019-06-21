package com.demo.util;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //于HashSet的区别
        //HashSet无序，存入和取出的顺序不一致
        //TreeSet有序,默认按asic码排序，自定义对象需要实现Comprable接口,
        //TreeSet不能有null元素
        //HashSet可以放入一个null元素
//        treeSet.add(null);
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("======================treeSet");
        System.out.println(treeSet);

        HashSet hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println("======================hashSet");
        System.out.println(hashSet);


    }
}
