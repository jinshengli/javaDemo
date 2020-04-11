package se;

public class ClassB {

    public ClassB(){
        System.out.println("ClassB()");
    }

    public static void main(String[] args) {
        ClassC c = new ClassC();
    }
}

class ClassC{

    ClassA a = new ClassA();
    ClassB b;

    public ClassC(){

        System.out.println("ClassC");
        b = new ClassB();
    }
}
