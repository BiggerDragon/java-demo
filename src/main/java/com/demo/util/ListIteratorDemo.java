package com.demo.util;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {

    public static void main(String[] args) {
        //ListIterator和Iterator的区别?
        //1.Iterator能遍历List和Set集合，而ListIterator只能遍历List集合
        //2.ListIterator有add方法，可以添加元素，而Iterator没有
        //3.ListIterator和Iterator都可以顺序向后遍历，ListIterator还可以向前遍历
        //4.ListIterator可以定位当前索引位置
        //5.二者都可以删除元素，ListIterator还可以使用set方法修改元素，后者不行

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(11);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(9);
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            System.out.println("nextIndex:" + listIterator.nextIndex());
            System.out.println("preIndex:" + listIterator.previousIndex());
            System.out.println(listIterator.next());

            //该方法只能在next方法调用之后，既没有调用过add方法也没有调用过remove方法
            //替换元素
            listIterator.set(100);
        }

        System.out.println(linkedList);
    }
}
