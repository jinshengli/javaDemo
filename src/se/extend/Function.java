package se.extend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * create by ljs @date  2020/5/4 8:31
 */
public class Function {

    public static void main(String[] args) {

        List<A> as = null;

        List<B> ab = null;

        List k = as;

        List<Object> ao = null;

        List<?> ll = ao;

        List<D> ad = null;

        List<? extends B> eb = null;


        eb = ad;

        List<? extends A> ea = null;

//        List<Object> a = Collections.singletonList(eb);


//        try {
//
//            throw new IOException();
//        }catch (FileNotFoundException e){
//            System.out.println();
//        }catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("io");
//        }
    }

}


class A {}
class B extends A {}
class C extends A {}
class D extends B {}