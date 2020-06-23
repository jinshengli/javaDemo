package reflesh;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by ljs on 2020/6/23 20:09
 * <p>
 * description:  通过反射获取方法；
 */
public class GetMethods {

    private static Class clazz;
    private static Constructor constructor;

    static {

        try {
            clazz = Class.forName("reflesh.Student");
            constructor = clazz.getConstructor(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取当前所有的成员方法，包括私有的(不包括继承的)
     */
    public static void getAllMethodsThisOwn() {

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }

    /**
     * 获取所有"公有方法"；（包含了父类的方法也包含Object类）
     */
    public static void getPublicMethodsAll() {

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

    }

    /**
     *
     *  获取公共方法；当前类 + 继承而来的共有方法。
     */
    public static void getOneMethod() throws NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {

        Method setOdMethod = clazz.getMethod("setName", String.class);
        Object obj = clazz.newInstance();
        setOdMethod.invoke(obj, "哈化娿");
        System.out.println("obj=" + obj);

    }

    /**
     *  获取当前类定义的方法。 包括公有 + 其他
     */
    public static void getOneMethodFromThis() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Method setNameMethod = clazz.getDeclaredMethod("test", Integer.class);
        setNameMethod.setAccessible(true);
        Object obj = clazz.newInstance();
        setNameMethod.invoke(obj, 100);

    }




    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // getAllMethods();
        // getPublicMethods();
        // getOneMethod();

        getOneMethodFromThis();

    }


}
