package com.demo.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo2 {

    private AtomicInteger integer = new AtomicInteger(0);

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    private AtomicLong atomicLong = new AtomicLong(100L);

    //支持普通对象的原子操作
    private AtomicReference<String> atomicReference = new AtomicReference<>("I like you");

    //

    public static void main(String[] args) {

    }


}
