package com.demo.util;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        //Verctor:初始容量10,每次扩容增长一倍
        //ArrayList:初始容量10,每次扩容增长0.5倍
        Vector vector = new Vector();
        vector.add(null);
        vector.add(null);
        vector.add(null);
        vector.add(null);
        System.out.println(vector);

        //虽然Vector是同步的，但是如果你寻求在迭代的时候改变集合，你需要使用CopyOnWriteArrayList
        //否则依然会抛出ConcurrentModificationException

    }
}
