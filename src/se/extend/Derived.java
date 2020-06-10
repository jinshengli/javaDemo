package se.extend;

/**
 * 只要是被子类重写的方法，不被super调用都是调用子类方法
 */

public class Derived extends Base
{
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }

    public static void main(String[] args) {
        Base b = new Derived();
        b.methodOne();
    }
}