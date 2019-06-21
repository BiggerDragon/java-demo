package com.demo.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionDemo {
    public static void main(String[] args) {
        Throwable throwable = new Throwable();
        throwable.printStackTrace();
        //Thrwoable是Error和Exception的父类
        //表示所有可以抛出的异常
        Error error = new Error();
        //Error表示编译时错误和系统错误,系统错误不用管,编译错误，编译器会报错
        Exception exception = new Exception();
        //Exception则是可以抛出的基本类型
        //Exception分为运行时异常和非运行时异常
        //运行时异常可以不处理,可以编译通过，但是运行时可能会出错
        RuntimeException runtimeException = new RuntimeException();
        //非运行时异常必须处理否则编译不通过
        IOException ioException = new IOException();
        //非运行时异常又叫检查异常，需要处理，处理的方式：可以向throw到上层，也可以try-catch

        //常见的运行时异常:
        NullPointerException nullPointerException = new NullPointerException();
        ArithmeticException arithmeticException = new ArithmeticException();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        ClassCastException classCastException = new ClassCastException();
        NegativeArraySizeException negativeArraySizeException = new NegativeArraySizeException();
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        SecurityException securityException = new SecurityException();
        NumberFormatException numberFormatException = new NumberFormatException();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        //常见非运行时异常
        IOException ioException1 = new IOException();
        EOFException eofException = new EOFException();
        FileNotFoundException fileNotFoundException = new FileNotFoundException();
        SQLException sqlException = new SQLException();
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException();

        //常见Error
        //当调用抽象方法时抛出
        AbstractMethodError abstractMethodError = new AbstractMethodError();
        //断言失败
        AssertionError assertionError = new AssertionError();

        //当虚拟机尝试或者类装载器试图实例化某个类的时候，找不到类定义
        NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError();

        //当内存不足时，创建一个对象没有足够的内存
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
        //当栈空间不足时抛出，递归调用方法，然后栈空用尽
        StackOverflowError stackOverflowError = new StackOverflowError();



    }
}
