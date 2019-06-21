package com.demo.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        //LinkedHashMap与HashMap的区别?
        //前者可以保证存入的顺序与取出的顺序一样，既可以保证有序
        //后者不能保证存入与取出的顺序一致
        //前者可以有一个null的key和多个null的value
        //后者可以有一个null的key和多个null的value
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);
        linkedHashMap.put("four", 4);
        linkedHashMap.put("five", 5);
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=============HashMap====================");
        HashMap hashMap = new HashMap();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        hashMap.put("five", 5);
        Iterator iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        linkedHashMap.put("six" , null);
        linkedHashMap.put("seven" , null);
        System.out.println(linkedHashMap);
    }
}
