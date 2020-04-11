package se;


public class StaticMethodDemo {

    public static void main(String[] args) {
        Super01 sup = new Sub01();

        sup.m1();
        sup.m2();

        Sub01 sub = (Sub01) sup;

        sub.m1();
        sub.m2();



    }

}


class Super01{

    public static void m1(){
        System.out.println("m1 in Super");
    }

    public void m2(){
        System.out.println("m2 in Super");
    }

    private void me(){
        System.out.println("super01");
    }

}

class Sub01 extends Super01{
    public static void m1(){
        System.out.println("m1 in Sub01");
    }

    public void m2(){
        System.out.println("m2 in Sub01");
    }

    public void m3(){

    }

}
