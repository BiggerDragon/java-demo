package com.demo.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioClientDemo {
    private final static String LOCAL_IP = "192.168.43.225";

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress(LOCAL_IP, 10004));

        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                //连接事件发生
                if (selectionKey.isConnectable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    if (channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    //向服务器发送数据
                    channel.write(ByteBuffer.wrap("我是客户端，我们连上了".getBytes()));

                    //为了可以接受服务器端的数据，需要为Channel添加读事件
                    channel.register(selector, SelectionKey.OP_READ);

                }else if (selectionKey.isReadable()){
                    //读事件发生
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    channel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));

                    //写
//                    channel.write(ByteBuffer.wrap("我是客户端我收到了你的信息".getBytes()));
                }
            }
        }



    }
}
