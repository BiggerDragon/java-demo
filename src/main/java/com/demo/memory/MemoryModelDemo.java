package com.demo.memory;

public class MemoryModelDemo {

    public static void main(String[] args) {
        //java内存模型?
        //java内存模型由，堆，java栈和方法区,本地方法栈，程序计数器构成,
        //堆是存放对象的地方，线程共享，实例变量，静态变量以及常量池都在堆中
        //栈是线程私有的空间，存放一个个栈帧，每一栈帧对应一个方法调用，存放着局部变量等信息
        //局部变量是线程私有的，不存在线程安全问题
        //方法区：线程共享的区域，放了类的一些信息
        //程序计数器用来指示执行哪一条指令
        //本地方法栈是为本地方法服务的，功能和java栈一样


    }
}
