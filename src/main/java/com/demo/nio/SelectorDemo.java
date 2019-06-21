package com.demo.nio;

import java.io.IOException;
import java.nio.channels.Selector;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {

        //create a selector
        Selector selector = Selector.open();
        System.out.println(selector.isOpen());
        System.out.println(selector.keys());
        System.out.println(selector.provider());
        System.out.println(selector.select());
        System.out.println("未到达");
    }

}
