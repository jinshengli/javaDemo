package se.innerclass;

/**
 *
 * 描述： 成员内部类，定义在类内的成员内。
 *
 *成员内部类
 *
 *
 *
 * 可以:
 * 1. 访问外部类的所有东西，【静态、非静态】成员、方法。
 * 2. 定义非静态成员和方法
 * 3. 可以定义用final修饰过的静态成员
 *
 *
 *
 * 不可以：
 * 1. 不可定义静态成员和静态方法。【为什么】
 *
 *   成员内部类在使用的时候才加载，并且使要有外部类实例化后才能生成，这和类加载初始化歧义了。
 *
 *
 *
 * 生成对象：
 *
     InnerClass innerClass = new InnerClass();
     Inner inner = innerClass.new Inner();
 *
 */
public class InnerClass {

    private static int anInt;

    private int b;




    public class Inner{

        private int wo;

        //private static int p; 不可以静态成员

        private final static int wp=100;



//        private static void me(){
//
//        } 不可以静态方法

        public void print(){
            System.out.println(anInt);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {

        InnerClass innerClass = new InnerClass();
//
//        Inner inner = innerClass.new Inner();
//        inner.print();


    }


}
