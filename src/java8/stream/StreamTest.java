package java8.stream;

import java8.bean.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        // 希望获取 热量大于300的
        List<String> stringList = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName) // 获取名字
                .limit(3)
                .collect(Collectors.toList()); // 转成list
        System.out.println(stringList);

        // 获取是蔬菜的菜单
        List<String> collect = menu.stream()
                .filter(d -> d.isVegetarian() == true)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Dish> dishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(dishes);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        // 帅选出 偶数和不重复的
        List<Integer> integerList = numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(integerList);

        // 提取菜单的名字
        List<String> meName = menu.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
        System.out.println(meName);

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
    }

}
