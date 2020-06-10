package se.innerclass;

/**
 * create by ljs @date  2020/5/5 9:03
 *
 *  匿名内部类的使用。
 *
 *  1， 匿名内部类，必须继承一个类或者一个接口，但是两者不可兼得
 *  2 匿名内部类中是不能定义构造函数的。
 *  3 匿名内部类中是不能定义构造函数的。
 *  4 匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。
 *  5 匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
 *
 *
 */



public class AnnonymousClass {

    private final int sw = 0;


    public static void main(String[] args) {

        int p = 9;
        final int ei = 99;

        Annon t = new Annon(100){
            private int anInt = 123;
            //  private static int e = 123;
//            static {
//                System.out.println("xxx");
//            }

            @Override
            public void print() {
                super.print();
                System.out.println(p);
                System.out.println(this.anInt);
                System.out.println(ei);
                System.out.println(super.getO());
            }
        };

        t.print();



    }
}

class Annon{
    private int o;
    public Annon(){

    }
    public Annon(int o){
        this.o = o;
    }

    public void print(){
        System.out.println("ooo: " + o);
    }

    public int getO(){
        return this.o;
    }
}