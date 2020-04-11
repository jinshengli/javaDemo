package extenddemo;


/**
 *
 * 说明了 类的继承时。   子类会继承父类的所有变量，子类可以修改父类的方法。
 *
 *
 *  B 继承了A 所有的变量。
 *  重写了方法  fun()
 *
 *
 */


public class MyB extends MyA {

    public int anInt = 1;

    public static int m = 10;

    public void fun(){
        System.out.println("B fun  " + this.anInt);
    }

    public static void main(String[] args) {
        MyA myA = new MyA();
        System.out.println(myA.anInt);
        myA.fun();

        // 当通过该变量访问它所引用的对象的实例变量时，该实例变量的值取决于该变量的声明类型；

        MyB myB = new MyB();
        System.out.println(myB.anInt);

        // 当通过该变量来调用它所引用的对象的方法时，该方法取决于它实际引用的对象的类型。
        myB.fun();

        MyA myA1 = new MyB();
        System.out.println(myA1.anInt);
        myA1.fun();

        MyA myA2 = myB;
        System.out.println(myA2.anInt);
        myA2.fun();

    }


}
