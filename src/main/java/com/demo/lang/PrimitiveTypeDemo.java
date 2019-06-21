package com.demo.lang;

import java.nio.charset.Charset;

public class PrimitiveTypeDemo {

    public static void main(String[] args) {

        //面试题
        //1、short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 +=1;有什么错?
        int i = 1;
        //大类型转小类型，需要强制转换
        short s = (short) (i + 1);
        //byte short char与int类型进行运算都变成int
        short s2 = (short) (s + 2);

        short s3 = 2;
        //+=进行了内部自动强转
        s3 += 2;

        //2.char类型变量能不能储存一个中文的汉子，为什么？
        //char类型变量存放unicode编码的字符

        System.out.println(Charset.defaultCharset());

        //3.编码的问题?

        //4.int和Integer的区别?
        //int是java8中基本类型之一，Java为每一种基本类型都提供了封装类
        //int的默认值为0，而Integer的默认值为null

        //5.switch语句能否作用在byte上，能否作用在long上，能否作用在string上？
        byte b1 = 10;
        long l1 = 10;
        switch (b1){

        }
        switch (Byte.valueOf("1")){

        }
        switch (Short.valueOf("2")){

        }
        switch (Character.valueOf('c')){

        }
        //不能放long
//        switch (l1){
//
//        }

        String string = "sdf";
        switch (string){

        }

        //结论:byte,short,char(包括他们的封装类型)可以隐式向int装换，所以可以使用
        //而long的存储范围大于int,不能够进行隐式转换，所以不能使用long
        //String可以使用
        //就是说小类型转大类型可以隐式转换，而大类型转小类型需要强制转换

        //5、能否在不进行强制转换的情况下将一个 double 值赋值给 long 类型的变量？
        //为什么double和long都是8字节，而double存储的范围要比long广
        //double 是以n*2^m的形式存储的，他不能将它表示范围内的所有数都精确的表示出来
        //而long是可以的
        //因为double表示的范围比long广，所以必须强制转换


        //6、java 中 3*0.1 == 0.3 将会返回什么？true 还是 false？
        System.out.println(3 * 0.1);
        System.out.println(3 * 0.1 == 0.3);
        System.out.println(3 * 0.2);
        //因为浮点数不能完全精确的表示出来，一般都会损失精度
        System.out.println(2*0.1);
        System.out.println(2*0.2);
        System.out.println(2*0.3);
        System.out.println(5 * 0.1);
        System.out.println(7*0.1);

        //7.java 中 float f = 3.4; 是否正确？
        //单精度转双精度，大类型转小类型，需要强转
        //java中浮点数默认是双精度
        float f = 3.4f;


    }
}
