package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class LambdaTest {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);  // 处理一下
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f) {

        List<R> result = new ArrayList<>();
        for ( T s:list) {
            result.add(f.apply(s)); // f.apply(s) 可以将 T 的类型转换成R的类型、 这个行为有传入的lambda表达式确定
        }
        return result;
    }


    public static void main(String[] args) {

        forEach(
                Arrays.asList(1,2,3,4,5),
                // (Integer i) -> System.out.println(i) 打印
                (Integer i) -> {
                    System.out.println(i);}
        );

        //  字符串的长度。
        List<Integer> map = map(Arrays.asList("lambda", "in", "action"), (String s) -> s.length());
        System.out.println(map);

    }

}
