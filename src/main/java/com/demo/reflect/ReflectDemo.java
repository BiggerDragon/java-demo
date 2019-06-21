package com.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) {
        System.out.println(Dog.class.getCanonicalName());
        try {
            Class dogClass = Class.forName("ed.dragon.java.reflect.Dog");
            Constructor constructor = dogClass.getConstructor();
            Object dog = constructor.newInstance();
            System.out.println(dog);

            Constructor constructor1 = dogClass.getConstructor(String.class, Integer.class);
            Object dog2 = constructor1.newInstance("哈士奇", 100);
            System.out.println(dog2);

            Method barkMethod = dogClass.getMethod("bark");
            barkMethod.invoke(dog2);

            Field name = dogClass.getDeclaredField("name");

            System.out.println(name.getName());
            name.setAccessible(true);
            System.out.println(name.get(dog2));;
            name.set(dog, "大黄");
            System.out.println(dog);

            Field ageField = dogClass.getDeclaredField("age");
            System.out.println(ageField.get(dog2));

            ageField.set(dog, 23);
            System.out.println(dog);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


}

class Dog{

    private String name;

    public Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }

    public void bark(){
        System.out.println(this.name + " is barking!");
    }

    public int getAge(){
        return this.age;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}