package com.demo.thread;

public class WaitAwaitSleep {

    public static void main(String[] args) {

        //1.wait方法和sleep方法的不同
        //相同点：是当前线程暂停，把运行机会让给其他线程
        //如果线程在等待期间被中断，则抛出InterruptedException
        //都是native方法

        //不同点wait会是当前线程阻塞并释放锁，而sleep并不会释放锁
        //wait是Object类的方法，sleep是Thread的静态方法
        //使用的地方不一样:wait只能用在同步代码块中，而sleep可以用在任何地方

        //2.wait和await的区别
        //相同点，二者都会使当前线程阻塞，并释放锁
        //不同点:wait使Object的方法，await是ConditionObject的方法
        //wait用在synchronized的同步代码块中，而await用在ReentrantLock的lock方法和unlock方法之间
        //wait对应的唤醒线程的方法是notify和notifyAll(), await对应的是signal()和signalAll()
        //也就是说notify用来唤醒wait的线程,signal用来唤醒await的线程

    }
}


