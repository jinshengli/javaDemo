package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * create by ljs on 2020/7/1 20:24
 *
 * description: 从 classpath 下读取配置文件  通过class对象的getResourceAsStream
 */
public class ReadProperties {

    public void getProper() throws IOException {

        InputStream resourceAsStream = getClass().getResourceAsStream("/a.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties);

    }

    public static void main(String[] args) throws IOException {

        ReadProperties properties = new ReadProperties();

        properties.getProper();


    }


}
