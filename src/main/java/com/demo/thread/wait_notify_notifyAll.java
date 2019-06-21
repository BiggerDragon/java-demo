package com.demo.thread;

public class wait_notify_notifyAll {

    public static void main(String[] args) {
        //notify()、notifyAll()、wait()都是Object类的本地方法
        //1）wait()、notify()和notifyAll()方法是本地方法，并且为final方法，无法被重写。
        //2.调用某个对象的wait方法会让当前线程阻塞，并且当前线程必须拥有此对象的monitor(锁)
        //3.调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，
        // 如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程
        //4.调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程；
    }
}
