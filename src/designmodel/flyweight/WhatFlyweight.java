package designmodel.flyweight;


/**
 *  什么是享元模式？
 *
 *  所谓“享元”，顾名思义就是被共享的单元。享元模式的意图是复用对象，节省内存，前提
 *  是享元对象是不可变对象。
 *
 *  不可变对象是指：引用和字段属性都不能变。
 *
 *  不仅仅相同对象可以设计成享元，对于相似对象，我们也可以将这些对象中相同的部分（字段）提取出来，设计成享
 * 元，让这些大量相似对象引用这些享元。
 *
 * 享元不能有setter方法， 通过一个工程创建这些享元，并且缓存这些享元。
 *
 *
 */


public class WhatFlyweight {


    public static void main(String[] args) {

        // 利用享元模式， 在LongCache 工厂类中缓存 Long 对象 [-128 - 127 ]

        Long l = Long.valueOf(10L);  // LongCache  [-128 ~ 127 ]
        Integer integer = Integer.valueOf("123"); // IntCache

        Long o = 10L;

        System.out.println(l == o );


        String s = "ccc";
        String st = "ccc"; // 常见线程池

        System.out.println(s == st);




    }


}
