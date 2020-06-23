package reflesh;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * create by ljs on 2020/6/23 18:54
 * <p>
 * description:
 *         通过反射获取类的属性字段。
 */
public class GetFields {

    private static Class clazz;
    private static Constructor constructor;

    static {

        try {

            clazz = Class.forName("reflesh.Student");
            constructor = clazz.getConstructor();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


    /**
     *  获取当前类的所有属性
     */
    public static void getAllFields() {

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    /**
     *  获取当前类的public属性
     */
    public static void getPublicFields() {

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }


    /**
     *  获取当前类某个私有属性，并且给该属性赋值 【前提生成对象】
     */
    public static void getOneField() throws
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {

        Object object = constructor.newInstance();
        Field phoneNumField = clazz.getDeclaredField("phoneNum");
        phoneNumField.setAccessible(true); // 设置私有属性可访问
        phoneNumField.set(object,"17806262078");  // 给属性赋值
        System.out.println(object);
    }

    /**
     *  可以获取该类拥有的所有公共属性，包括继承父类公有的属性。
     */
    public static void getOnePublicFile() throws
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {

        Object obj = constructor.newInstance();
        Field nameField = clazz.getField("name");
        nameField.set(obj, "ljs");
        System.out.println(obj);

    }




    public static void main(String[] args) throws Exception {

           getAllFields();
//         getPublicFields();

      //  getOneField();

      //  getOnePublicFile();

    }





}
