package designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 *  这是通过 java JDK 实现的动态代理
 *
 *  1。 创建动态代理的处理器？  【DynamicProxyHandler】 实现 invocationHandler 接口，
 *
 *      实现其中的 invoke 方法 invoke(Object, method, arg)
 *
 *      你需要关注的参数是 Object =  被代理对象。  在实现DynamicProxyHandler 需要依赖被代理对象。
 *
 *  2。 创建创建动态代理的类 【UserControllerCreateDynamicProxy】。
 *
 *      主要是通过 Proxy.newProxyInstance(ClassLoader, interface, invocationHandler)
 *
 *      1）ClassLoader 是被代理类的类加载器。
 *      2）被代理类拥有的接口。
 *      3）被代理类的 invocationHandler.
 *
 */


public class UserControllerCreateDynamicProxy {


//    private UserController userController;
//
//    public UserControllerCreateDynamicProxy(){
//        this.userController = new UserController();
//    }



    public Object createProxy(Object proxiedObject){

        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();

        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);


        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);


    }

    private class DynamicProxyHandler implements InvocationHandler{

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject){
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            long startTimeStamp = System.currentTimeMillis();
            System.out.println("执行前时间戳" + startTimeStamp);

            Object result = method.invoke(proxiedObject, args);

            long endTimeStamp = System.currentTimeMillis();

            long responseTimeStamp = endTimeStamp - startTimeStamp;

            System.out.println(responseTimeStamp);
            System.out.println("执行前时间戳" + endTimeStamp);

            return result;
        }
    }

    public static void main(String[] args) {

        UserController userController = new UserController();

        UserControllerCreateDynamicProxy proxy = new UserControllerCreateDynamicProxy();

        IUserController usercontrollerProxy = (IUserController) proxy.createProxy(userController);

        usercontrollerProxy.register();
        usercontrollerProxy.login();


//      下面是不能运行的， 听过只能代理接口。  PersonController 需要实现接口， createProxy 转换成 它实现的接口
//        PersonController personController = new PersonController();
//
//        UserControllerCreateDynamicProxy proxy1 = new UserControllerCreateDynamicProxy();
//        Object proxy2 =  proxy1.createProxy(personController);



    }


}
