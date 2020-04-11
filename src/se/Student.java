package se;

public class Student{
    public void Student(){}
    void init(){
        age = 10;
        name = "limy";
    }
    public Student(String name){
        this.init();
        this.name = name;
    }
    public Student(String name, int age){
        this.init();
//        this(name);
        this.name = name;
        this.age = age;
    }
    int age;
    String name;
}