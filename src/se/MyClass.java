package se;

public class MyClass {
    public int value;

    static int anInt = 10;


    static {
        anInt = 20;
        System.out.println(" in static ");
    }

    public MyClass(){
        value = 1;
        System.out.println("my class");
    }

    public MyClass(int i ){
        System.out.println("my class (int)");
        this.anInt = i;
        value = i;

    }

    public void printValue(final int value){
        System.out.println(value);
    }

    public void changeValue(int value){
        value = value * 2;
        System.out.println(value);
    }

    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        int value = 5;
        final int fvalue = 10;

        myClass.printValue(value);
        myClass.printValue(fvalue);

        myClass.changeValue(value);
        myClass.changeValue(fvalue);

        final Integer integer = new Integer(10);






//        MyClass mc1 = new MyClass();
//        System.out.println(mc1.anInt);
//        MyClass mc2 = new MyClass(10);
//        System.out.println(mc2.anInt);


    }


}
