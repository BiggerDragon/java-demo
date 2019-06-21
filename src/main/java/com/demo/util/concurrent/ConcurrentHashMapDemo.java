package com.demo.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        //默认的capacity 16, 他是Segement数组，对每个segement加锁，而不是整个hash表加锁,即分段锁
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("one", 1);
        concurrentHashMap.put("two", 2);
        concurrentHashMap.put("three", 3);
        concurrentHashMap.put("four", 4);
        concurrentHashMap.put("five", 5);
        concurrentHashMap.put("six", 6);
        System.out.println(concurrentHashMap);

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        System.out.println(copyOnWriteArrayList);

        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.add(2);
        copyOnWriteArraySet.add(2);
        copyOnWriteArraySet.add(3);
        copyOnWriteArraySet.add(4);
        System.out.println(copyOnWriteArraySet);


    }
}
