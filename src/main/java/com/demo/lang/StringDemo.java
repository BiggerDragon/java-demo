package com.demo.lang;

public class StringDemo {

    public static void main(String[] args) {
        /**1.创建了几个对象**/
        System.out.println("问:String str = new String(\"abcd\")+\"c\" 创建了几个对象");
        String str1 = "NBA";
        String str2 = "NBA";
        System.out.println(str1 == str2);

        /**"CBA"查看字符串常量池是否有该对象，没有则添加到常量池，new String()回拷贝"CBA"**/
        String str3 = new String("CBA");
        System.out.println(str1 == str3);
        String str4 = "CBA";
        System.out.println(str3 == str4);

    }
}
