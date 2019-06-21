package com.demo.util;

import java.util.Arrays;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) {
        String [] strings = {"A", "B", "C", "D"};
        List list = Arrays.asList(strings);
        System.out.println(list);
        System.out.println(list.get(0) == strings[0]);
        Dog [] dogs = {new Dog("二哈"), new Dog("金毛"), new Dog("德牧")};
        List dogList = Arrays.asList(dogs);
        System.out.println(dogList);
        System.out.println(dogList.get(0) == dogs[0]);

        Object [] dogs1 = dogList.toArray();

        Object [] dogs2 = Arrays.copyOf(dogs, 2);
        System.out.println(Arrays.toString(dogs2));
        System.out.println(dogs2[0] == dogs[0]);

    }

    private static class Dog{
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
