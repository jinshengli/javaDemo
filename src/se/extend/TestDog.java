package se.extend;

/**
 * create by ljs on 2020/5/6 8:10
 */
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }


    public void bark() {
        System.out.println("动物可以叫");
    }
}
class Dog extends Animal{
    public void move(){
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
public class TestDog{
    public static void main(String args[]){
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        b.move();
        b.bark();
    }

    long test = 123L;
    double ei = 123;
    float aFloat = -412;
    float getaFloat = 123;
    long getTest = 0123;

   Object object = "f";
  // Double aDouble = 100;

    byte aByte = 12;
    char getS = (char) aByte;


    char s = '\u0639';

    float aFloat1 = 12344L;
    double aDouble = 1234L;

    short aShort = 12;

    double sdd = aShort;

    float sff = aShort;

//    Integer i=100;//没有问题
//    Integer i2=100.0;//报红杠，因为默认是double
//    Integer i3=(byte)100;//报红杠
//
//    Short aS = 100; //没有问题，是不是很神奇？说明上面的规律对Short不适用
//
//    Double d=100; //报红杠
//    Double d=100.0;//没有问题
//    Double d=100.0f;//报红杠
//
//    double d55=100;//没有问题，100是int类型，自动转换为double.
//    Double d=Double.valueOf("100"); //正确
//    Double d=Double.valueOf(100);//正确
//    Double d=new Double(100);//正确





}
