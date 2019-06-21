package com.demo.io;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

public class WriterDemo {

    public void doDemo(){
//        Writer writer = Writer.nullWriter();
        Writer writer = null;
        String string = "ABC";
        char [] chars = new char[10];
        string.getChars(0, string.length(), chars, 0);
        System.out.println(Arrays.toString(chars));
        /**StringWriter内有一个StringBuffer属性**/
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("ABC");
        System.out.println(stringWriter.toString());
        try {
            writer.append('c');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doStringDemo(){
        String str = "ABC@DEFG";
        int i = str.compareTo("BC");
        System.out.println(i);
        System.out.println("B".compareTo("A"));
        System.out.println("C".compareTo("C"));

        int index = str.indexOf((int)'B');
        System.out.println("index="+index);
        System.out.println(str.indexOf("BC"));
        System.out.println(str.indexOf((int)'A',2));
        System.out.println(str.indexOf('A', 0));
        System.out.println(str.indexOf("A", 3));

        String regex = "^ABC$";
        System.out.println(str.matches(regex));
        System.out.println("ABC".matches(regex));
        System.out.println("ABCD".matches("ABC"));

        char c = str.charAt(0);
        System.out.println(c);

        String str2 = str.substring(1);
        System.out.println(str2);

        /**如果常量池中存在str直接返回否则添加到常量池**/
        String str3 = str.intern();
        System.out.println(str3);
        System.out.println(str3 == str);

        System.out.println(str.isEmpty());

        System.out.println("".isEmpty());
//        System.out.println("".isBlank());
//        System.out.println("    \n ".isBlank());

        IntStream intStream = str.chars();
        System.out.println(intStream);

        String string = "张ABC";
        System.out.println(string.codePointAt(0));
        System.out.println(string.codePointAt(1));
        System.out.println(string.codePointAt(2));
        System.out.println(string.codePointBefore(2));
        System.out.println(string.codePointCount(0, 2));
        System.out.println(string.codePoints());
        System.out.println(string.concat("何立雪"));

        System.out.println(string.compareToIgnoreCase("张abc"));


        CharBuffer charBuffer = CharBuffer.allocate(4);
        charBuffer.put("张ABC");
        System.out.println(string.contains(charBuffer));
        System.out.println(string.contentEquals(charBuffer));
        System.out.println(string.endsWith("C"));
        System.out.println(string.startsWith("A"));
        System.out.println(string.startsWith("张"));
        System.out.println("ABCDAEEE".lastIndexOf('A'));
        /**从指定的索引反向搜索**/
        System.out.println("ABCDABEE".lastIndexOf("B", 2));
//        Stream<String> stringStream = string.lines();
//        System.out.println(stringStream);

        /**java11**/
//        System.out.println(string.repeat(2));
        System.out.println("ABCAHA".replace('A', 'a'));
        System.out.println("ABCAHA".replaceAll("A", "哈"));
        System.out.println("ABCAHA".replaceFirst("A", "且"));
        System.out.println(Arrays.toString("A,c,D,t".split(",")));
        System.out.println(Arrays.toString("A,B,C,D".split(",", 2)));
//        System.out.println("   dfdf  ".strip());
        System.out.println("   ddff   ".trim());
//        System.out.println("  sdfdsf sdfd ".stripLeading());
//        System.out.println(" sdfsdf sdfds   ".stripTrailing());
        System.out.println("".toCharArray());
        System.out.println("aaa".toUpperCase());
        System.out.println("aaa".toUpperCase());
        System.out.println("AAA".toLowerCase());

    }
}
