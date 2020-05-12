package reflesh;

/**
 * create by ljs on 2020/5/12 14:50
 *
 * 系统类加载器 --> 扩展类加载器 --> 启动类加载器
 */
public class GetClassLoader {


    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


    }

}
