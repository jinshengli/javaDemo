package reflesh;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * create by ljs on 2020/6/23 17:08
 * <p>
 * description: 通过反射获取构造器；并且使用
 */
public class GetConstructor {


    private static Class clazz;

    static {
        try {
            clazz = Class.forName("reflesh.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  批量获取所有的构造器.
     */
    public static void getAllContructor() {

        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {

            System.out.println(constructor);
        }

    }

    /**
     *  获取所有【公有的】构造函数
     */
    public static void getPublicContructor() {

        Constructor[] constructors = clazz.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

    }


    /**
     *  获取一个构造函数；  范围：所有的方法中
     * @param paramClass
     * @throws NoSuchMethodException
     */
    public static void getOneContructorFromAll(Class ...paramClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor declaredConstructor = clazz.getDeclaredConstructor(paramClass);

        System.out.println(declaredConstructor);

        boolean accessible = declaredConstructor.isAccessible();
        if ( !accessible ) {
            declaredConstructor.setAccessible(true); // 如果是私有的，设置方法可以被访问
        }

        Object student = declaredConstructor.newInstance("护手霜");
        System.out.println(student);

    }

    /**
     * 获取一个构造函数，从公共的构造方法中获取。
     * @param id
     * @param name
     * @param paramClass
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */

    public static void getOneConstructorFromPublic(Integer id, String name, Class ...paramClass) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clazz.getConstructor(paramClass);
        System.out.println(constructor);

        Object student = constructor.newInstance(id, name);
        System.out.println(student);
    }



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // getAllContructor();
        getPublicContructor();

        System.out.println("获取从所有的构造器中一个构造器");
        getOneContructorFromAll(String.class);

        System.out.println("获取一个public的构造函数");
        getOneConstructorFromPublic(11, "三个呢", Integer.class, String.class);

    }


}





