package com.demo.util;

import java.util.*;

public class SummaryDay03 {

    public static void main(String[] args) {
        //java常用集合
        //List
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        List vector = new Vector();
        //Set
        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();
        //Map
        Map hashMap = new HashMap();
        Map hashTable = new Hashtable();
        Map treeMap = new TreeMap();

        //工具类
        Collections.sort(arrayList);
        Collections.synchronizedSet(hashSet);
        int [] ints = {1 , 32, 3, 54, 21, 232};
        Arrays.sort(ints);


    }
}
