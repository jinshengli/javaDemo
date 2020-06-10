package se.extend;

/**
 *
 *
 * TestSuper和Date的getClass都没有重写，
 * 他们都是调用Object的getClass，
 * 而Object的getClass作用是返回的是运行时的类的名字。
 * 这个运行时的类就是当前类，所以
 *
 *
 */

import java.util.Date;
public class SuperTest extends Date{
    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getName());
        System.out.println(super.getClass().getSuperclass());

        System.out.println(this.getClass().getName());

        System.out.println(this.getClass());
    }

    public static void main(String[]args){
        new SuperTest().test();
    }
}