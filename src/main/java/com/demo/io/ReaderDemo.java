package com.demo.io;

import java.io.*;
import java.util.Arrays;

public class ReaderDemo {

    public void doDemo(){
//        Reader reader = Reader.nullReader();
        Reader reader = null;
        try {
            int i = reader.read();
            System.out.println(i);
            char [] chars = new char[10];
            i = reader.read(chars);
            System.out.println(i);
            System.out.println(reader.read(chars, 0, chars.length));

            StringReader stringReader = new StringReader("ABCDE张");
            System.out.println((char)stringReader.read());
            /**最大读两个字符**/
            stringReader.mark(2);
            System.out.println((char)stringReader.read());
            /**重置位置可以复读*/
            stringReader.reset();
            System.out.println((char)stringReader.read());
            System.out.println(stringReader.read(chars));
            System.out.println(Arrays.toString(chars));
            /**跳过指定字符数并返回跳过的字符数**/
            long l = stringReader.skip(1);
            System.out.println(l);

            FileReader fileReader = new FileReader("t1.txt");
            char c = (char)fileReader.read();
            System.out.println(c);

            System.out.println(fileReader.markSupported());
            /**输入流和输出流的reset方法概念不一样*/

            InputStream inputStream = new ByteArrayInputStream("花里胡哨".getBytes());
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            System.out.println(inputStreamReader.getEncoding());
            System.out.println((char)inputStreamReader.read());
            System.out.println(inputStreamReader.ready());
            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
