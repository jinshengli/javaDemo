package reflesh;

/**
 * create by ljs on 2020/6/23 16:42
 * <p>
 * description:
 *      获取class对象的三种方式；
 *
 *
 */
public class GetClazz {


    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = Student.class;

        Student student = new Student();
        Class aClass = student.getClass();


        Class aClass1 = Class.forName("reflesh.Student");

        System.out.println(clazz == aClass); // true

        System.out.println(aClass1 == aClass);// true



    }


}
