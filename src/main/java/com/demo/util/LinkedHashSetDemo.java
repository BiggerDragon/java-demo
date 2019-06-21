package com.demo.util;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        //内部使用LinkedHashMap实现
        //可以保证插入的顺序和取出的顺序一致
        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");
        linkedHashSet.add(null);
        linkedHashSet.add("four");

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
