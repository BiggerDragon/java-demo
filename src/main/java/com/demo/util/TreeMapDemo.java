package com.demo.util;

import java.util.*;

/**
 * 红黑树实现TreeMap
 *
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        treeMap.put("C", 3);
        treeMap.put("D", 4);
        treeMap.put("D", 5);
        treeMap.put("E", null);
        System.out.println(treeMap);
        //TreeMap的每一个Entry是红黑树的一个节点
        //TreeMap是一种有序的key-value集合

        //遍历
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Set keySet = treeMap.keySet();
        System.out.println("================keySet=====================");
        System.out.println(keySet);
        Collection values = treeMap.values();
        System.out.println("================values=====================");
        System.out.println(values);
        //TreeMap和HashMap的区别
        //HashMap有capacity和加载因子用来调优,无序
        //TreeMap没有调优选项，因为它总处于平衡状态,有序(自然排序或者自定义排序)
        //HashMap:适用在Map中插入和定位元素
        //TreeMap:适用按自然排序和自定义排序遍历键
        //TreeMap不允许有null的key,但可以有null的value
        //HashTable既不允许有null的key，也不允许有null的value
    }
}
