package se.cast;

/**
 * create by ljs on 2020/5/8 20:43
 */
public class Student implements Cloneable{



    //引用类型
    private Subject subject;
    //基础数据类型
    private String name;
    private int age;

    public Student() {
    }

    public Student(Subject subject, String name, int age) {
        this.subject = subject;
        this.name = name;
        this.age = age;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
