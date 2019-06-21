package com.demo.thread;

public class MutexDemo {

    public static void main(String[] args) {

        //AbstractQueuedSynchronizer:抽象队列同步器
        //除了Mutex，ReentrantLock/CountDownLatch/Semphore这些同步类的实现方式都差不多，
        //不同的地方就在获取-释放资源的方式tryAcquire-tryRelelase。掌握了这点，AQS的核心便被攻破了。
    }
}
