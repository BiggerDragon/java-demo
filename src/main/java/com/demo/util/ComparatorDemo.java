package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {

    public static void main(String[] args) {
        Comparator<Dog> comparator1 = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1==null && o2==null)
                    return 0;
                if (o1==null && o2!=null)
                    return -1;
                if (o1!=null&& o2==null)
                    return 1;
                if (o1.age == o2.age)
                    return 0;
                else if (o1.age > o2.age){
                    return 1;
                }else
                    return -1;
            }
        };

        Comparator<Dog> comparator2 = (Dog o1, Dog o2)->{
            if (o1==null && o2==null)
                return 0;
            if (o1==null && o2!=null)
                return -1;
            if (o1!=null&& o2==null)
                return 1;
            if (o1.age == o2.age)
                return 0;
            else if (o1.age > o2.age){
                return 1;
            }else
                return -1;
        };

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
        Collections.sort(arrayList, comparator1);
        System.out.println(arrayList);

    }

    private static class Dog{

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
    }
}
