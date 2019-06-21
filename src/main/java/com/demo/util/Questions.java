package com.demo.util;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 枚举类型不是Enumeration
 * 查看java type体系
 */
public class Questions {

    public static void main(String[] args) {
        //Enumeration和Iterator的区别？
        //1.前者只能读取数据，不能修改数据，后者可以删除数据
        //2.前者不支持fail-fast机制，后者支持
        // 使用Iterator扁砾石，当多个线程同时修改集合，可能会产生fast-fail事件
        // 抛出ConcurrentModificationException

        //Vector和HashTable实现了Enumeration
        Vector vector = new Vector();
        vector.add("one");
        vector.add("two");
        vector.add("three");
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        Hashtable hashtable = new Hashtable();
        hashtable.put("one", 1);
        hashtable.put("two", 2);
        hashtable.put("three", 3);
        hashtable.put("four", 4);
        Enumeration enumeration1 = hashtable.keys();
        while (enumeration1.hasMoreElements()){
            Object key = enumeration1.nextElement();
            System.out.println(key +"=" + hashtable.get(key));
        }

        //Iterator是什么？
        //Iterator接口提供遍历任何Collection接口

        //为什么没有iterator.add()方法向集合添加元素？
        //因为iterator不能保证迭代顺序

        ListIterator listIterator = vector.listIterator();

        //通过fail-fast属性你明白了什么?
        //每次尝试获取下一个元素的时候，fail-fast属性检查当前集合的任何改动，
        //然后抛出ConcurrentModificationException

        //fail-fast和fail-safe有什么区别?
        //java.util包中集合都被设计为fail-fast,
        //java.util.concurrent中的集合都是fail-safe的，从不抛出ConcurrentModificationException

        //在迭代的是时候如何避免ConcurrentModificationException?
        //可以使用并发集合来避免
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator iterator = copyOnWriteArrayList.iterator();

        //UnsupportedOperationException是什么?
        //表示不支持的操作,
        Collections.unmodifiableCollection(copyOnWriteArrayList);
        //如果对copyOnWriteArrayList进行add或者remove操作会抛出UnsupportedOperationException是什么


        //哪些集合提供对元素的随机访问?
        //ArrayList HashMap TreeMap HashTable

        //EnumSet

        //那些集合是线程安全的?
        //Vector HashTable Properties Stack
        //Stack是Vector的子类, Properties是HashTable的子类
        //可以使用并发包下的集合，因为他们都是工作在集合的克隆上，所以他们是线程安全的

        //java8之后HashMap进行了改变,当链表中的元素超过8个就会将链表变成红黑树

        //如何保证集合不能修改?
        //使用Collections.unmidifiableCollection方法包装集合
        //创建同步集合
        //Collections的通用算法,排序，搜索，混编，最大最小
        //大写的O表示的时一个算法的性能,时间复杂度

        //java集合中使用的最好实践?
        //如果指定了大小，我们应该使用Array而不是ArrayList
        //如果我们想要根据插入顺序遍历Map，我们应该使用TreeMap而不是HashMap
        //如果我们不想重复，应该使用Set
        //使用jdk提供的不可变类作为Map的key,以避免自己实现equals和hashCode
        //尽可能使用Collections工具类


    }

}
