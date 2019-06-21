package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 老龙
 * @date 2019-05-28
 * @Description Collections工具类学习
 *
 */
public class CollectionsDemo01 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(10);
        list.add(-2);
        list.add(123);
        list.add(2);
        list.add(32);
        list.add(11);
        list.add(16);
        list.add(87);
        list.add(45);
        System.out.println("原数组");
        System.out.println(list);
        /**反转**/
        Collections.reverse(list);
        System.out.println("反转后");
        System.out.println(list);
        /**随机排序*/
        Collections.shuffle(list);
        System.out.println("随机排序后");
        System.out.println(list);
        /**自然排序的升序排序**/
        Collections.sort(list);
        System.out.println("自然排序");
        System.out.println(list);

        /**lambda写法*/
        Comparator<Integer> comparator = (n1, n2)->{
            if (n1 > n2)
                return -1;
            else if (n1 == n2)
                return 0;
            else
                return 1;
        };

        Collections.sort(list, comparator);
        System.out.println("自定义排序");
        System.out.println(list);
        /**交换两个索引的位置*/
        Collections.swap(list, 9, 1);
        System.out.println("交换位置");
        System.out.println(list);
        /**rotate**/
        System.out.println("rotate 集合");
        Collections.rotate(list, 3);
        System.out.println(list);
        Collections.rotate(list, -3);
        System.out.println(list);

    }


}
