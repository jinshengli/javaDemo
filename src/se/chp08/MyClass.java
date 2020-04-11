package se.chp08;

public class MyClass implements IA {
    @Override
    public void m1() {

    }

    public static void main(String[] args) {
        IA ia = new MyClass();
        ia.m1();
        System.out.println(IA.a);
    }
}
