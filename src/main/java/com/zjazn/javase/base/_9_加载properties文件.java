package com.zjazn.javase.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 我们需要从resource上读取到 .properties 文件，然后转为文件输入流，传入Properties加载
 */
public class _9_加载properties文件 {
    public static void main(String[] args) throws IOException {
        InputStream fs = _9_加载properties文件.class.getClassLoader().getResourceAsStream("_9_.properties");

        Properties properties = new Properties();
        properties.load(fs);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user="+user+", password="+password);
    }
}
