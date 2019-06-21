package com.demo.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

    private final static String LOCAL_IP = "192.168.43.225";

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(LOCAL_IP, 10004);
        OutputStream outputStream = socket.getOutputStream();
        String data = "我是客户端，你好服务器!";
        outputStream.write(data.getBytes());

        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[1204];
//        int len = inputStream.read(bytes);
//        System.out.println("我收到:"+new String(bytes, 0, len));

        int len = -1;
        String result = "";
        while ((len = inputStream.read(bytes)) != -1){
            String s = new String(bytes, 0, len);
            result += s;
        }
        System.out.println(result);

        socket.close();
    }
}
