package com.demo.lang;

public class AutoWrapperDemo {

    public static void main(String[] args) {
        //对于两边都是包装类型，==比较的是引用，equals()比较的是值
        //对于一边有表达式，==比较的是数值，equals()不会自动类型转换
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 300;
        Integer i4 = 300;
        System.out.println(i1 == i2);//true
        System.out.println(i3 == i4);//false

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 300.0;
        Double d4 = 300.0;
        System.out.println(d1 == d2);//false
        System.out.println(d3 == d4);//false

        Boolean b1 = false;
        Boolean b2 = false;
        Boolean b3 = true;
        Boolean b4 = true;
        System.out.println(b1 == b2);//true
        System.out.println(b3 == b4);//true

        Float f1 = 100.0f;
        Float f2 = 100.0f;
        Float f3 = 300.0f;
        Float f4 = 300.0f;
        System.out.println(f1 == f2);//false
        System.out.println(f3 == f4);//false


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 300;
        Integer f = 300;
        Long l1 = 3L;
        Long l2 = 2L;

        System.out.println(c == d);//true 比较cache
        System.out.println(e == f);//false 比较引用
        System.out.println(c == (a + b));//true 比较值， +运算得到原始类型，然后c自动拆箱为基本类型
        System.out.println(c.equals(a + b));//true 比较值, 判断(a+b) 是不是Integer 如果是则获取基本类型的值然后==运算
        System.out.println(l1 == (a+b));//true 比较值 int向上转型为long
        System.out.println(l1.equals(a+b));//false 比较引用，因为a+b不是Long型 equals()不会隐式转换类型
        System.out.println(l1.equals(l2+a));//true l2+a得到long 自动装箱后得到Long型，然后比较的是值


        Integer i5 = 444;
        int i6 = 444;
        System.out.println(i5 == i6);//true 比较值
        System.out.println(i5.equals(i6));//true 比较值

    }
}
