package com.demo.util;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (int i = 0 ; i < 4 ; i ++){
            System.out.println(stack.pop());
        }
    }
}
