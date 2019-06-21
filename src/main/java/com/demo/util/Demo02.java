package com.demo.util;

import java.util.*;

/**
 * 集合
 */
public class Demo02 {

    public static void main(String[] args) {
        //一下六个集合类都不是线程安全的
        //数组实现,泛型给什么类型就可以存放什么类型
        //初始容量10,每次扩容为原来的1.5倍,若新增后超过这个容量，则容量为新增后所需的最小容量
        //可克隆可序列化
        //非同步
        ArrayList arrayList = new ArrayList();
        arrayList.add("asdf");
        arrayList.add(new Dog("二哈"));
        System.out.println(arrayList);
        //链表实现,内部类Node,保存上一个节点和下一个节点的引用(地址)
        //继承于AbstractSequencetialList的双向链表.实现了Deque(双向队列)和Queue(队列)接口
        //可以进行队列操作和双向队列操作,并可以作为栈(后进先出)来使用
        //可克隆、可序列化
        //非同步
        //无论如何，千万不要通过随机访问去遍历LinkedList
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Dog("A"));
        linkedList.add(new Dog("B"));
        linkedList.add(new Dog("C"));
        System.out.println(linkedList);
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        System.out.println(linkedList.get(0));
        //获取第一个元素
        System.out.println(linkedList.peek());
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);

        //并不能简单的说LinkedList比ArrayList更适合做删除增加操作
        //java中没有指针，删除时通常是指定删除某个索引的元素，首先需要定位元素，然后再删除
        //LinkedList定位慢删除块
        //ArrayList定位块删除慢
        //具体效率还看删除的元素的位置

        HashSet hashSet = new HashSet();

        //每个对象都有一个默认的散列码，其值就是对象的内存地址
        //可以重写hashCode方法
        //如何理解两个对象equals方法比较相同，hashCode方法比较必须相同
        //要满足:逻辑上相同的两个对象要放在相同的位置上
        //如果equals比较相同，而hashCode比较不相同，是不是意味着两个逻辑上相同的对象可以放在不同的位置上
        //如何理解equals比较不相同，hashCode比较可以相同？
        //不同的对象可以放在hash表的相同位置上，但是会形成链表，链表越长，性能越低

        //java中hash表的默认大小都是16,16条链表
        //如果16条链表中有0.75的链表上有数据，则加载因子达到默认的0.75，需要重新散列
        //即抛弃原来的结构，重新开启空间
        //为什么说HashSet的查询效率提高了？
        //更具散列码和散列表的数组的大小计算除余后直接得到数据的存储位置
        //查找的代价就是链表中
        hashSet.add("ABC");
        hashSet.add("ABC");
        hashSet.add("EFG");
        System.out.println("hashset:"+hashSet);
        //HashSet就是通过HashMap来保存数据，HashSet的值就是HashMap的key
        //HashSet总结:
        //1.HashSet使用HashMap实现，以HashMap的key作为HashSet的值，
        // 用一个Object对象常量作为HashMap的value
        // HashSet可以允许一个null的值，HashSet不允许重复元素

        //String重写了hashCode方法
        String s1 = "AAA";
        System.out.println(s1.hashCode());
        String s2 = new String("AAA");
        System.out.println(s1 == s2);
        System.out.println(s2.hashCode());
        //StringBuffer没有重写
        StringBuffer stringBuffer = new StringBuffer("BBB");
        System.out.println("StringBuffer:" + stringBuffer.hashCode());
        StringBuffer stringBuffer1 = new StringBuffer("BBB");
        System.out.println(stringBuffer == stringBuffer1);
        System.out.println("StringBuffer:" + stringBuffer1.hashCode());

        TreeSetDemo treeSet = new TreeSetDemo();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();

        Vector vector = new Vector();

    }


    private static class Dog{
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
