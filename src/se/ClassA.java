package se;

public class ClassA {

    public ClassA(){
        System.out.println("ClassA()");
    }


    void method(){
        System.out.println("method");
    }

//     int method(int i){
//        System.out.println("method (int)");
//      }

    public static void main(String[] args) {
        ClassA a = new ClassA();

        a.method();

    }

}
