package com.demo.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(null, null);
        System.out.println(hashMap);
        hashMap.put(null, null);
        hashMap.put("a", null);

        System.out.println(hashMap);

        Hashtable hashtable = new Hashtable();
        //HashTable不能接受null作为key,也不能接受null为value
//        hashtable.put(null, null);
//        hashtable.put("a", null);
        hashtable.put("a", "1");
        System.out.println(hashtable);
        //HashMap非synchronized的，HashTable是synchronized的
        //ConcurrentHashMap是HashTable的替代，比前者性能更佳
        //什么叫做fast-fail策略?
        //HashMap不是线程安全的，当在使用迭代器的过程中，其他线程修改了HashMap，或者是使用map的remove方法
        //会抛出ConcurrentModificationException，但迭代器本身remove方法并不会抛出此异常
        //HashTable的Enumerator迭代器不是fast-fail的

        //如何使HashMap同步
        Map synMap = Collections.synchronizedMap(hashMap);

    }
}
