package com.demo.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 智障
 */
public class GetIpDemo {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            System.out.println(networkInterfaces.nextElement());
        }
    }
}
