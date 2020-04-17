package collection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  collection.toArray
 *  带参数： 数组长度需要标明正确， 长度 < collection.size() 放回 null 元素
 *
 * 其他还好，
 *
 * 不带参数返回Object 类型的对象数组。
 *
 */
public class ListToArray {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);

        list.add(2);

        list.add(3);

        list.add(4);
        // 下面这行被注释的代码这么写是无法转化成数组的，无参 toArray 返回的是 Object[],
// 无法向下转化成 List<Integer>，编译都无法通过
// List<Integer> list2 = list.toArray();
// 演示有参 toArray 方法，数组大小不够时，得到数组为 null 情况
        Integer[] array0 = new Integer[2];
        list.toArray(array0);

        System.out.println(array0);
        for (Integer a : array0){
            System.out.println(a);


        }
        System.out.println("+++++");

        Integer[] array1 = new Integer[list.size()];
        list.toArray(array1);

        System.out.println(array1);
        for (Integer a : array1){
            System.out.println(a);


        }
        System.out.println("+++++");


        // 演示数组初始化大小大于实际所需大小，也可以转化成数组
        Integer[] array2 = new Integer[list.size() + 2];
        list.toArray(array2);

        System.out.println(array2);
        for (Integer a : array2){
            System.out.println(a);


        }
        System.out.println("+++++");

    }


}

