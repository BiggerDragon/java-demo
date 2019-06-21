package com.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * 泛型通配符extends super ?
 *
 *
 */
public class Demo03 {

    public static void main(String[] args) {

        //只能用于方法返回，Father和Father的父类都能接受，但是入参类型无法确定
        //只能接收null
        List<? extends Father> list = new ArrayList<>();
//        list.add(new Son());
        list.add(null);
//        list.add(new Father());
        Father father = list.get(0);
        //父类型可以接受子类型参数
        Object object = list.get(0);
        //子类型不能接受父类型参数
//        Son son = list.get(0);

        //参数类型下界是Father,只能放入T类型，且要满足T类型父类至少是Father
        //就是说只能放入Father的子类型
        Vector<? super Father> vector = new Vector<>();
        vector.add(new Father());
//        vector.add(new Object());
        vector.add(new Son());
//        vector.add(new String(""));

        //返回类型是未知的
        Object object2 = vector.get(0);
        System.out.println(object2);
//        Father father1 = vector.get(0);
//        Son son = vector.get(0);



    }

    private static class Father{

    }
    private static class Son extends Father{

    }
    private static class Daughter extends Father{

    }

}
