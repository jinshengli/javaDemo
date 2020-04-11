package se.tmp;

import se.MyClass;

public class MySubClass extends MyClass {

    public MySubClass(int value){
//        super(value);
        this.value = value;
    }

    public static void main(String[] args) {

        MySubClass mySubClass = new MySubClass(1);

    }

}
