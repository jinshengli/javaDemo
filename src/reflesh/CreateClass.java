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

    private Integer id;
    public String name;



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

    private void getPerson(){
        System.out.println("person");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{

    public static Integer od = 0;

    public String studentName;

    private Integer studentId;


    protected int age;
    char sex;
    private String phoneNum;



    public Student() {

    }

    public Student(Integer id, String name) {
        this.studentId = id;
        this.name = name;
    }

    public Student(Integer id) {
        this.studentId = id;
    }

    private Student(String name) {
        this.name = name;
    }



    private Student(Integer id, Integer id2) {
        this.studentId = id + id2;
    }


    public void test(Integer integer, String  name){
        System.out.println(integer + " " + name);
    }

    private void test(Integer integer){
        System.out.println(integer);
    }

    public  Integer getOd() {
        return od;
    }

    public  void setOd(Integer od) {
        Student.od = od;
    }


    private void test(){
        System.out.println("student test +++++++++=== method");

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                "} " + super.toString();
    }
}