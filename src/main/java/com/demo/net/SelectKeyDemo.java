package com.demo.net;

import java.nio.channels.SelectionKey;

public class SelectKeyDemo {

    public static void main(String[] args) {
        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_WRITE);
    }
}
