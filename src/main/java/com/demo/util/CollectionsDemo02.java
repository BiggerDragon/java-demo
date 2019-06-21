package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 老龙
 * @date 2019-05-28
 * @Description Collections 查找替换操作
 *
 */
public class CollectionsDemo02 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("12321312");
        list.add("张");
        list.add("刘大山");
        list.add("黄志忠");
        list.add("龙个");
        list.add("飞机");
        list.add("大炮");
        /**list必须是有序的,返回索引**/
        //先进行排序
        Collections.sort(list);
        System.out.println("排序String");
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, "飞机"));
        System.out.println(Collections.binarySearch(list, "12321312"));
        System.out.println(Collections.binarySearch(list, "张"));
        System.out.println(Collections.binarySearch(list, "刘大山"));

        /**更具元素的自然顺序返回最大元素**/
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(10);
        integers.add(-2);
        integers.add(123);
        integers.add(2);
        integers.add(32);
        integers.add(11);
        integers.add(16);
        integers.add(87);
        integers.add(45);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);
        System.out.println("max:");
        System.out.println(Collections.max(integers));
        System.out.println("min:");
        System.out.println(Collections.min(integers));

        /***替代所有元素**/
        Collections.fill(integers, 0);
        System.out.println(integers);

        /**元素出现的次数**/
        System.out.println(Collections.frequency(integers, 0));
        System.out.println(Collections.frequency(integers, 1));


    }
}
