package com.demo.thread;

public class Questions {

    public static void main(String[] args) {
        //1.i++是线程安全的么？
        //不是
        //加上volatile可以保证线程安全么？
        //不能
        //怎么解决？
        //1.对i++的代码块加锁
        //2.使用原子类

        //2.什么是CAS?
        //compare and swap:即比较和替换是设计并发算法时用到的一种技术


        //3什么是原子操作?
        //指不会被线程调度机制打断的操作，操作一旦开始就一直运行到结束，
        // 中间不会有任何context switch(线程上下文切换)

        //4.为什么volatile不能保证线程安全?
        //volatile能够保证可见性：保证使用其修饰的对象在cpu上的缓存对每个线程是可见的
        //顺序性：可以保证线程操作对象时时顺序执行的
        //一致性：保证每个线程每次读取到的对象都是最新的，
        // 注意:但是不能保证回写到主存中的数据不会覆盖其他线程修改的结果

        //5.Java中什么是竞态条件?
        //多线程竞争的情况下，本来需要先执行的线程没有抢到资源，排到后面执行了

        //6. Java中如何停止一个线程？
        //java API没有提供如何停止一个线程的方法

        //7.一个线程运行时发生异常会怎样？
        //没有捕获异常，线程将终止

        //8.如何在两个线程间共享数据？
        //使用共享对象，或者向阻塞队列这种数据结构

        //9.Java中notify 和 notifyAll有什么区别？
        //notify不能唤醒某个具体的线程，只有一个线程等待时才有用武之地
        //notifyAll()会将所有的等待线程都唤醒

        //10.为什么wait, notify 和 notifyAll这些方法不在thread类里面？
        //java提供的锁是对象级的而不是线程级的，即锁属于对象

        //11. 什么是ThreadLocal变量？
        //


        //12.什么是FutureTask？
        //FutureTask是Future的实现类，表示一个异步的计算结果
        //通常和Callable接口配合使用，call()方法返回一个Future对象
        //可以判断计算是否完成，如果没有完成get方法会阻塞

        //13.Java中interrupted 和 isInterruptedd方法的区别？
        //

        //14.为什么wait和notify方法要在同步块中调用？
        //主要是因为Java API强制要求这样做，如果你不这么做，你的代码会抛出IllegalMonitorStateException异常。
        // 还有一个原因是为了避免wait和notify之间产生竞态条件。

        //15.为什么你应该在循环中检查等待条件?
        //

        //16.如何避免死锁？
        //Java多线程中的死锁 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象
        //死锁的发生必须满足以下四个条件：

        //互斥条件：一个资源每次只能被一个线程使用。
        //请求与保持条件：一个线程因请求资源而阻塞时，对已获得的资源保持不放。
        //不剥夺条件：线程已获得的资源，在末使用完之前，不能强行剥夺。
        //循环等待条件：若干线程之间形成一种头尾相接的循环等待资源关系。
        //避免死锁最简单的方法就是阻止循环等待条件，将系统中所有的资源设置标志位、排序，
        // 规定所有的线程申请资源必须以一定的顺序（升序或降序）做操作来避免死锁


        //17.怎么检测一个线程是否拥有锁？
        Thread.holdsLock(new Object());

        //18.JVM中哪个参数是用来控制线程的栈堆栈小的
        //

        //19. 有三个线程T1，T2，T3，怎么确保它们按顺序执行？
        //使用join方法

        //20.Thread类中的yield方法有什么作用？
        //Yield方法可以暂停当前正在执行的线程对象，让其它有相同优先级的线程执行。
        // 它是一个静态方法而且只保证当前线程放弃CPU占用而不能保证使其它线程一定能占用CPU，
        // 执行yield()的线程有可能在进入到暂停状态后马上又被执行

        //21. Java中Semaphore是什么？
        //Java中的Semaphore是一种新的同步类，
        // 它是一个计数信号。从概念上讲，从概念上讲，信号量维护了一个许可集合


        //22.如果你提交任务时，线程池队列已满。会时发会生什么？
        //事实上如果一个任务不能被调度执行那么ThreadPoolExecutor’s submit()方法将会抛出一个RejectedExecutionException异常。


        //23.Java线程池中submit() 和 execute()方法有什么区别？
        //两个方法都可以向线程池提交任务，execute()方法的返回类型是void，它定义在Executor接口中,
        // 而submit()方法可以返回持有计算结果的Future对象，
        // 它定义在ExecutorService接口中，它扩展了Executor接口，
        // 其它线程池类像ThreadPoolExecutor和ScheduledThreadPoolExecutor都有这些方法

        //24.如何在Java中创建Immutable对象？
        //通过构造方法初始化所有成员、对变量不要提供setter方法、将所有的成员声明为私有的，
        // 这样就不允许直接访问这些成员、在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝

        //25.Java中的ReadWriteLock是什么？
        //共享锁
        //

        //26.volatile 变量和 atomic 变量有什么不同？
        //volatile写操作会发生在后续的读操作之前, 但它并不能保证原子性
        //例如用volatile修饰count变量那么 count++ 操作就不是原子性的
        //而AtomicInteger类提供的atomic方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一

        //27.如果同步块内的线程抛出异常会发生什么？
        //锁是否释放,对于synchronized自动释放锁,对于Lock接口需要在finally块中释放锁

        //28.单例模式的双检锁是什么？
        //29.如何在Java中创建线程安全的Singleton？

        //30.写出3条你遵循的多线程最佳实践
        //  1.给你的线程起个有意义的名字
        //  2.避免锁定和缩小同步的范围
        //  3.多用同步类少用wait 和 notify 首先，
        //  CountDownLatch, Semaphore, CyclicBarrier
        //  和 Exchanger 这些同步类简化了编码操作，而用wait和notify很难实现对复杂控制流的控制
        //  4.多用并发集合少用同步集合

        //
    }
}
