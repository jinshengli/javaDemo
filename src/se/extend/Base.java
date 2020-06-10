package se.extend;

public class Base
{
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();


    }

    public void methodTwo()
    {
        System.out.print("B");
    }

    public static void main(String[] args) {
        int i = 0;
        i = i++ + i;
        System.out.println("I =" +i);


        String str = "xxxx";
        System.out.print(str.split(",").length);

    }
}
