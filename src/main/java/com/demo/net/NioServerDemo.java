package com.demo.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServerDemo {

    public static void main(String[] args) throws IOException {

        //open server-socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        //bind a port to the ServerSocket concerned with this Server socket channel
        serverSocketChannel.socket().bind(new InetSocketAddress(10004));

        //get a selector
        Selector selector = Selector.open();

        //register some SelectorKey
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){

            //util event reach otherwise blocking
            selector.select();

            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();
                selectionKeyIterator.remove();
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("accepted...");
                    //set unblock
                    socketChannel.configureBlocking(false);
                    socketChannel.write(ByteBuffer.wrap("我是服务器我收到了!".getBytes()));
                    //get readable event 给通道设置读权限
                    socketChannel.register(selector, SelectionKey.OP_READ);

                }else if (selectionKey.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    //读到缓冲区
                    int readInt = channel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));

                    ByteBuffer outBuffer = ByteBuffer.wrap("I am server.Thanks for your data!".getBytes());

                    //数据写到通道
                    channel.write(outBuffer);

                }
            }



        }


    }
}
