import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAndLamda {


    public static void main(String[] args) {

        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python", "java");


        skills.stream().distinct().forEach(skill-> System.out.println(skill + ","));

        System.out.println("------------");
        skills.stream().distinct().forEach(System.out::println);

        System.out.println("------------");

        skills.stream().distinct().filter(skill -> ! skill.equals("python")).forEach(System.out::println);

        /**
         *  map
         */

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 5);

        numList.stream().map(num -> num * num).forEach( num -> System.out.println(num + ","));

        Set<Integer> collect = numList.stream().map(num -> num * num).collect(Collectors.toSet());

        collect.forEach(integer -> System.out.println(integer + ","));


    }


}
