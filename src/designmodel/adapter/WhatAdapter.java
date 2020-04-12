package designmodel.adapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  什么是适配者模式？ 【Adapter Design Pattern】
 *
 *  将不兼容接口装换成兼容的接口，让原本由于接口不兼容而不能一起工作的类
 *  可以一起工作。 【usb 接口】
 *
 *  实现适配者模式 2 种方式。
 *  1） 类适配器：继承被适配者的类 + 实现目标接口 [ ITarget ]
 *  2） 对象适配器：实现目标接口 + 委托适配者对象。
 *
 *
 *  典型例子：
 *      slf4j 接口  + 各种日志框架的适配器  、、、适配不同日志框架。
 *
 *      适配不同格式的数据：
 *
 *          Java 中的 Arrays.asList() 也可以看作一种数据适配器，将数组类
 *          型的数据转化为集合容器类型
 *
 */

public class WhatAdapter {


    public static void main(String[] args) {



        String []arr = {"wo", "si", "sha"};


        List<String> list1 = Arrays.asList(arr);

        System.out.println(list1);

        arr[1] = "wowooww";

        ArrayList<String> collection = new ArrayList<>(list1);





    }


}
