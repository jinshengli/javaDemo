package se.cast;



/**
 * create by ljs on 2020/5/8 20:46
 *
 *  实现浅拷贝: 实现Cloneable接口，然后直接重写 clone() 方法， super.clone()
 */
public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Subject subject = new Subject("yuwen");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);


        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        Subject subjectB = studentB.getSubject();
        subjectB.setName("lishi");

        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}
