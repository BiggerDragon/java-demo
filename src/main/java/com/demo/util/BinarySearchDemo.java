package com.demo.util;

import java.util.*;

public class BinarySearchDemo {

    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>();
        Integer [] intArr = new Integer[10];
        //生成随机数
        Random random = new Random();
        for (int i = 0 ; i < 10 ; i ++){
            int value = random.nextInt(100);
            integers.add(value);
            intArr[i] = value;
        }
        System.out.println("==================数组====================");
        System.out.println(Arrays.toString(intArr));
        System.out.println("==================未排序==================");
        System.out.println(integers);
        System.out.println("==================排序后==================");
        Collections.sort(integers);
        System.out.println(integers);
        System.out.println(binarySearch(integers, 56));
        for (Integer element: intArr){
            System.out.println("当前元素:" + element);
            System.out.println("二分查找的返回索引:" + binarySearch(integers, element));
        }

    }

    /**
     * 二分查找
     * @param integers
     * @param target
     * @return
     */
    public static int binarySearch(List<Integer> integers, Integer target){
        int start = 0;
        int end = integers.size()-1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (integers.get(mid) == target){
                return mid;
            }else if(integers.get(mid) > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
