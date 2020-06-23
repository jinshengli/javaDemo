package reflesh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * create by ljs on 2020/6/23 23:19
 * <p>
 * description:  读取配置文件，加载class对象，创建对象，运行方法
 *
 *      利用反射机制创建对象、
 */
public class ObtainObjByProperties {

    private static Properties properties = new Properties();


    public static void main(String[] args) throws IOException,
            ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {

        FileInputStream inputStream = new FileInputStream(new File("src/reflesh/st.txt"));
        properties.load(inputStream);
        String className = properties.getProperty("className");
        String method = properties.getProperty("method");

        Class clazz = Class.forName(className);
        Method declaredMethod = clazz.getDeclaredMethod(method);
        Object obj = clazz.newInstance();
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(obj);



    }

}
