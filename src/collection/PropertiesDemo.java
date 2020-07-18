package collection;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * create by ljs on 2020/6/20 8:55
 * <p>
 * description:
 *
 * Properties 继承Hashtable类，表示一个持久的属性集，
 * 属性列表中的每个键及对应的值都是一个字符串。
 *
 *
 */
public class PropertiesDemo {


    public static void main(String[] args) throws IOException {


        Properties properties = new Properties();

        properties.put("name", "shengma");
        properties.put("city", "李花花");


        System.out.println(properties);



        System.out.println(properties.get("city"));
        System.out.println(properties.getProperty("city"));
        System.out.println(properties.getProperty("city1", "beijing"));

        System.out.println(properties.getOrDefault("name", "李花花"));




        properties.store(new FileWriter("a.properties"), "属性");




        Properties properties1 = new Properties();


        FileReader fileReader = new FileReader("a.properties");

        properties1.load(fileReader);

        System.out.println(properties1);

        System.out.println(properties1.getProperty("name"));
        System.out.println(properties1.getProperty("wp", "zjopmg"));




    }


}
