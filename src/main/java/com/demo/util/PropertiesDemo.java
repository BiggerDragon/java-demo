package com.demo.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        System.out.println(Hashtable.class.isInstance(properties));
        properties.setProperty("one", "1");
        System.out.println(properties);

        StringReader stringReader = new StringReader("one=1\ntwo=2\nthree=3");
        properties.load(stringReader);
        System.out.println(properties);

    }
}
