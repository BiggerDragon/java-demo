package com.demo.exception;

public class Questions {
    public static void main(String[] args) {
        //1.如果执行finally代码块之前方法返回了结果，或者JVM退出了，finally块中的代码还会执行吗？
        //只有在try语句中执行System.exit(0),finally语句块才不会执行,否则即使try中有return语句，finally照样执行
        //2.如何处理OutOfMemoryError?
        //jvm内存过小、程序不严谨产生过多垃圾对象
        //设置JAVA_OPTS=-Xms128M -Xmx256M
        //-Xms表示最小内存 -Xmx表示最大内存
        //-Xss128K:栈空间大小
    }
}
