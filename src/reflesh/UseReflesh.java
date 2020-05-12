package reflesh;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by ljs on 2020/5/12 15:37
 *
 * 使用反射：
 * 1. 创建对象。
 * 2. 调用方法。
 * 3. 给某个字段赋值
 *
 *
 */
public class UseReflesh {


    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, NoSuchFieldException {


        Class aClass = Class.forName("reflesh.Student");

        // 调用无参构造函数创建对象
        Student student = (Student) aClass.newInstance();
        System.out.println(student.toString());


        Constructor declaredConstructor =
                aClass.getDeclaredConstructor(Integer.class, String.class);
        // 调用有参够着函数创建对象
        Student ljs = (Student) declaredConstructor.newInstance(001, "ljs");
        System.out.println(ljs);

        // 通过反射调用对象的方法。
        Method test = aClass.getDeclaredMethod("test", Integer.class, String.class);
        test.invoke(ljs, 100, "wowo");

        Method test1 = aClass.getDeclaredMethod("test", Integer.class);
        test1.invoke(ljs, 110);

        // 通过反射 get Field字段的值
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true); // 取消安全检查的开关。 还可以提高反射效率
        String str = (String) name.get(ljs);
        System.out.println("name=" + str);

        // 通过反射 setter Field字段的值

        name.set(student, "关注");
        System.out.println(student);


    }

}
