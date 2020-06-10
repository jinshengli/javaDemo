package jvm;

import java.lang.reflect.Proxy;

public class RuntimeInfoDemo {


    public static void main(String[] args) {


        Runtime runtime = Runtime.getRuntime();


        long l = runtime.maxMemory();

        long l2 = runtime.totalMemory();

        long l1 = runtime.freeMemory();

        System.out.println("最大内存：" + (double) l / 1024/1024);

        System.out.println("total 内存：" + (double) l2/1024/1024);

//        defineClass


    }

}
