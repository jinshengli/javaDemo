package java8;



import java8.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Test {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // lamda 表达式完成  行为参数化。
        List<Apple> redApples =
                filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Apple> evenWeigthList = filter(inventory, (Apple appple) -> appple.getWeight() % 2 == 0);

        System.out.println(redApples);
        System.out.println(evenWeigthList);

        // Comparator 排序  用Lambda表达式的话
        inventory.sort((Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight()) );
        System.out.println(inventory);

        // 用 Runnable 执行代码块

        // 1. 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这个是匿名内部类");
            }
        }).start();

        // 2. 使用Lambda表达式
        new Thread(()-> System.out.println("这个是Lamda表达式运行的")).start();


        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

    }

}
