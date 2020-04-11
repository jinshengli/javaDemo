package extenddemo;

public class TestStatic {

    public static void main(String[] args) {

        System.out.println(MyA.m);

        System.out.println(MyB.m);

        MyA.m = 123;

        System.out.println(MyB.m);

    }
}
