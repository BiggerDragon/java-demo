package com.demo.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("local host:" + inetAddress);
    }
}
