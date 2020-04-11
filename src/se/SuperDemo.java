package se;

public class SuperDemo {

    public static void main(String[] args) {

//        Sub sub = new Sub();
//        Sub sub = new Sub(1);
        Sub sub = new Sub("ljs");

        System.out.println("===========");

        sub.m1();
        sub.m2();

    }

}

class Super{

    int method(){
        return 0;
    }

    public Super(){
        System.out.println("Super()");
    }

    public void m1(){
        System.out.println("m1 in super");
    }

    public void m2(){
        System.out.println("m2 in super");
    }

    public Super(String  str){
        System.out.println("Super String ");
    }


}

class Sub extends Super{

    public int method(){
        return 0;
    }

    // 这个方法在子类存在
    void method(int n){

    }



    public Sub(){
        System.out.println("Sub");
    }

    public Sub(int i){
        this();
        System.out.println("sub int");
    }

    public Sub(String str){
        super(str);
        System.out.println("sub String");
    }

    public void m1(){
        System.out.println("m1 在sub");
        super.m1();
    }




}
