package se.innerclass;

/**
 *
 * 描述： 静态内部类，定义在类内的静态类。{what}，使用场景，静态内部类和外部类紧密联系，但是
 * 不依赖外部类的实例。
 *
 * 静态内部类
 *
 * 可以：
 * 1，访问外部类的静态方法和静态变量。
 * 2. 定义其他的任何类型的变量，【静态，非静态】都 ok， 和普通类没啥区别。
 * 3. 访问  StaticInnerClass.Inner inner = new StaticInnerClass.Inner();
 *
 * 不可以：
 * 1. 访问外部类的成员变量和成员方法。
 *
 *
 * 对于局部内部类，只有在方法的局部变量被标记为final或局部变量是effctively final的，内部类才能使用它们
 *
 */

public class StaticInnerClass {


    private static int a;

    private int b;

    int c;


    private static void te(){
        System.out.println("te");
    }

    public static class Inner{

        private int wow;
        private static double aDouble;

        public void print(){
            System.out.println(a);
//            System.out.println(b);
            te();
 //           System.out.println(c);
        }



    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.print();




}

}
