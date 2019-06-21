package com.demo.lang;

public class WrapperTypeDemo {

    public static void main(String[] args) {
        //1.为什么要使用基本类型？为什么需要包装类型?
        //因为基本类型速度快
        //因为包装类型使基本类型有了面向对象的特性，提供了很多有用的方法
        //比如最大值，最小值等，而且要集合不能存放基本类型，只能存放Object

        //2.什么使装箱和拆箱?
        //装箱指的是将基本类型自动装换成包装类型
        //拆箱指的是将包装类型自动转换成基本类型

        //编译时调用Integer.valueOf()进行装箱
        Integer i = 1;
        //编译时调用Integer.inValue()进行拆箱
        int j = i;

        //3.Integer的缓存值
        //创建Integer对象时，如果值在-127至128之间，则范围Integer缓存中已存在的引用
        //否则才创建新的Integer对象,除非显示使用new创建对象
        Integer integer = 12;//自动装箱
        Integer integer1 = 12;//自动装箱
        System.out.println(integer == integer1);
        Integer integer2 = new Integer(12);//显示使用new会创建新对象
        System.out.println(integer == integer2);
        Integer integer3 = Integer.valueOf(12);
        System.out.println(integer == integer3);
        //Integer.valueOf源码
//        public static Integer valueOf(int i) {
//            if (i >= IntegerCache.low && i <= IntegerCache.high)
//                return IntegerCache.cache[i + (-IntegerCache.low)];
//            return new Integer(i);
//        }

        //大于128创建了两个对象
        Integer integer4 = 129;
        Integer integer5 = 129;
        System.out.println(integer4 == integer5);
        System.out.println(integer4.equals(integer5));

        Byte b1 = 127;
        Byte b2 = 127;
        System.out.println(b1 == b2);
        Byte b3 = new Byte((byte)127);
        System.out.println(b1 == b3);

        //4.什么使hashCode值?
        //hashCode值是散列码，是用来确定对象在散列表中的索引位置
        //java集合中使用散列表实现的有HashMap HashSet HashTable
        //其他的非Hash表实现的集合hashCode没有用

        //5.equals()和hashCode()方法的关系?
        //equals()方法指的是两个对象在逻辑上相同
        //使用hash表时要做到:如果两个对象在逻辑上相同，那么他们的hashCode值一定要相同，
        //应为hashCode值不相同，就意味着，两个逻辑上相同的对象可以放在不能位置上，这不符合
        //hash表设计的原理
        //重写规则
        //1.equals()比较相同，则hashCode比较一定相同
        //2.equals()比较不相同，则hashCode比较不一定相同(相同则形成列表，影响性能)

        //6.自增（++）和自减（--）的问题
        int i1 = 1;
        i1 = i1 ++;
        System.out.println(i1);
        i1 = ++ i1;
        System.out.println(i1);
        //Java采取了中间变量缓存机制
        //++i：临时分配一个中间变量，先加1，赋给临时变量，最终运算的不是变量本身而是临时变量
        //i++:先赋值给临时变量，然后再加1
        //7.值传递与引用传递？
        //对于基本类型而言是值传递，指的是在进行函数调用时，传递的是变量的一个副本，对副本的修改不影响原来的变量
        //对对象来说是引用传递，指的是调用时传递的引用变量的一个副本而不是对象本身，对于对象而言都是通过引用来操作
        //实际的对象的，也就是形参和实参都指向了同一个对象，形参可以对对象进行修改，但如果形参执行了另一个对象，原来的对象
        //不受影响。

        //7.java引用类型有哪些？
        //类，接口类型，数组类型，枚举类型和注解类型


        //8.java包装类的常量池
        Double d1 = Double.valueOf(100);
        Double d2 = Double.valueOf(100);
        System.out.println(d1 == d2);
        //Byte Short Character Integer Long Float Double
        //除了Float和Double外都实现了常量池
        //Character没有继承Number
        //Number是Byte Short Integer Long Float Double的父类， 抽象类
        //这些包装类都实现了Comparable接口


        //两个NaN比较得到false
        float f1 = Float.NaN;
        float f2 = Float.NaN;
        System.out.println(f1 == f2);
        System.out.println(Float.compare(f1, f2));

        Double d3 = Double.NaN;
        Double d4 = Double.NaN;
        System.out.println(d3 == d4);
        System.out.println(Double.compare(d3, d4));

        float f3 = 0.0f/0.0f;
        System.out.println(f3 == f2);

        //对于+0和-0
        float f4 = -0.0f;
        float f5 = 0;
        System.out.println(f4 == f5);

        //正0比负0大，使用双等号比较号好
        System.out.println(Float.compare(f4, f5));

        //9.java自动装箱是编译特性？使用valueOf装箱，xxxValue()拆箱

        //10.基本类型和包装类型进行==运算时，先自动拆箱为基本类型，再进行比较


    }
}
