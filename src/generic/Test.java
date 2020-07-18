package generic;

import se.cast.Student;

/**
 * create by ljs on 2020/6/25 18:58
 * <p>
 * description:
 */
public class Test {

    public static void main(String[] args) {

        Mygeneric<String> gen = new Mygeneric<>();

        gen.getOO(new Student());
        // gen.getOO("dfd");

        Mygeneric.getWO("djsfods");


    }


}
