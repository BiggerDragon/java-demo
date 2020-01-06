package com.demo.io;

//import ed.dragon.util.NullUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class OutputStreamDemo {

    public void doDemo(){
//        OutputStream outputStream = OutputStream.nullOutputStream();
        OutputStream outputStream = null;
        try {
            /**什么都不做*/
            outputStream.write(1);
            outputStream.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(-1);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            System.out.println(bytes.length);
            System.out.println(new String(bytes));
            int i = bytes[0];
            System.out.println(i);

            /**java总是把byte当作有符处理**/
            i = bytes[0] & 0xFF;
            System.out.println(i);
            String string = byteArrayOutputStream.toString();
            System.out.println(string);

            Charset charset = Charset.defaultCharset();
            System.out.println(charset);
            Charset gbk = Charset.forName("GBK");
            System.out.println(gbk);

//            String gbkString = byteArrayOutputStream.toString(gbk);
//            System.out.println(gbkString);

            byte [] bytes1 = "zhang三".getBytes();
//            byteArrayOutputStream.writeBytes(bytes1);
            System.out.println(byteArrayOutputStream.toString());
            byteArrayOutputStream.write(bytes1, 0, bytes1.length);
            System.out.println(byteArrayOutputStream.toString());

            /**重置了byte数组**/
            byteArrayOutputStream.reset();
            System.out.println("after reset:"+byteArrayOutputStream.toString());
            byteArrayOutputStream.write("花里胡哨".getBytes());
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("size:"+byteArrayOutputStream.size());

            byteArrayOutputStream.reset();
            byteArrayOutputStream.write("ABC".getBytes());
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("size:"+byteArrayOutputStream.size());

            /**向另一个输出流输出字节*/
            FileOutputStream fos = new FileOutputStream("out.txt");
            byteArrayOutputStream.writeTo(fos);

            FileChannel fileChannel = fos.getChannel();
            System.out.println(fileChannel);

            byteArrayOutputStream.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifierDemo(){
        /**
         *
         * 只要满足某一个条件就可以访问是或的关系
         * 例如:用protected修饰的变量只要满足同类、同胞、子类中任意一个条件都可以访问
         *
         * public 同类、同包、子类、不同包
         * protected 同类、同包非子类、同包子类、不同包子类
         * default 同类、同包
         * private 同类
         */
        /**不同包也不是子类无法访问protected变量*/
        /**System.out.println(NullUtil.NAME);*/
        /**无法访问default变量**/
        /**System.out.println(NullUtil.CLASS_LOADER_NAME);**/

        /**无法访问**/
        /**System.out.println(StringNullUtil.NAME);**/

    }

//    static class StringNullUtil extends NullUtil{
//        public boolean isEmpty(String string){
//
//            /**不同包子类可以访问**/
//            System.out.println(NAME);
//
//            /**不同包无法访问default的变量**/
//            /**System.out.println(CLASS_LOADER_NAME);**/
//
//            if (string==null || "".equals(string))
//                return true;
//            else return false;
//        }
//    }
}
