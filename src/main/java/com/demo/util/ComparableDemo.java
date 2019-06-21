package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo {

    public static void main(String[] args) {
        Dog dog1 = new Dog("二哈", 2);
        Dog dog2 = new Dog("金毛", 3);
        Dog dog3 = new Dog("阿拉斯加", 6);
        Dog dog4 = new Dog("藏獒", 4);
        Dog dog5 = new Dog("德牧", 11);

        ArrayList<Dog> arrayList = new ArrayList();
        arrayList.add(dog1);
        arrayList.add(dog2);
        arrayList.add(dog3);
        arrayList.add(dog4);
        arrayList.add(dog5);
        System.out.println("=================排序前");
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println("=================排序后");
        System.out.println(arrayList);
    }

    /**
     * Comparable为泛型接口
     */
    private static class Dog implements Comparable<Dog>{

        private String name;
        private Integer age;

        public Dog(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Dog o) {
            if (o==null)
                return 1;
            if (this.age == o.age)
                return 0;
            if (this.age > o.age)
                return 1;
            return -1;
        }
    }
}
