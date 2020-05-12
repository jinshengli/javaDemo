package reflesh;



/**
 * create by ljs on 2020/5/12 11:58
 *
 * 获取类对象的三种方法 [创建反射的三种方式]
 *
 *
 */

public class CreateClass {

    public static void main(String[] args) throws ClassNotFoundException {

        // 通过实例的 getClass() 获取类对象
        Person person = new Person();
        Class aClass = person.getClass();
        System.out.println(aClass.hashCode());

        // 通过Class.forName
        Class aClass1 = Class.forName("reflesh.Person");
        System.out.println(aClass1.hashCode());

        // 通过xxx.class
        Class aClass2 = Person.class;
        System.out.println(aClass2.hashCode());


    }

}

class Person{

    Integer id;
    String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person{

    public static Integer od = 0;

    private Integer id;

    private String name;

    public Student() {

    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    public static void me(){

    }

    public void test(Integer integer, String  name){
        System.out.println(integer + " " + name);
    }

    public void test(Integer integer){
        System.out.println(integer);
    }

    public static Integer getOd() {
        return od;
    }

    public static void setOd(Integer od) {
        Student.od = od;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private void test(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}