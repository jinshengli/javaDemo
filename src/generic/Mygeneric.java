package generic;

import se.cast.Student;

/**
 * create by ljs on 2020/5/13 16:10
 *
 * 泛型方法。
 *
 * 静态方法 支持泛型方法
 *
 */
public class Mygeneric<E> {


    public static <T> void getWO(T data){
        System.out.println("heheh");
    }

    public <T extends Student> void getOO(T e) {
        System.out.println(e);
    }


}
