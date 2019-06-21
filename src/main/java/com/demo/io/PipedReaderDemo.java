package com.demo.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderDemo {

    public static void main(String[] args) {

        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        try {
            pipedReader.connect(pipedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new ReaderTask(pipedReader)).start();
        new Thread(new WriterTask(pipedWriter)).start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static class ReaderTask implements Runnable{

        private PipedReader pipedReader;

        public ReaderTask(PipedReader pipedReader) {
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {

            try {
                System.out.println("读者...");
//                while (true){
                    char [] chars = new char[10];
                    int i = -1;
                    while ((i = pipedReader.read(chars, 0, chars.length))!=-1){
                        System.out.println(new String(chars,0, i));
                    }
//                }
            }catch (IOException e){
                e.printStackTrace();
            }


        }


    }

    private static class WriterTask implements  Runnable{

        private PipedWriter pipedWriter;

        public WriterTask(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            System.out.println("写者...");
            String data = "ILOVEHELIXUEFOREVER";
            try {
                pipedWriter.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
