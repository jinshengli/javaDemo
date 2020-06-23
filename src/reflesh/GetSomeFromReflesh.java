package reflesh;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * create by ljs on 2020/5/12 15:17
 *
 * 通过反射获取类对象中的 字段对象、方法字段、
 *
 */
public class GetSomeFromReflesh {


    public static void main(String[] args) throws NoSuchFieldException {

        Class c1 = Student.class;
        System.out.println(c1.hashCode());

        Field[] fields = c1.getFields(); // 返回当前类的public 类对象
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------");
        fields = c1.getDeclaredFields(); // 返回当前类的所有字段对象
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------");
        Field od = c1.getField("od");
        System.out.println("field: " + od);

        System.out.println("--------------");

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("getMethods: " + method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("declaredMethods: " + method);
        }
        System.out.println("--------------");
        Constructor[] constructors = c1.getConstructors();
    }

}
