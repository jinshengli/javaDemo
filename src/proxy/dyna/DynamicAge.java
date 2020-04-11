package proxy.dyna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicAge {

        static class MyHandler implements InvocationHandler {
        private Object proxy;

        public MyHandler(Object proxy){
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>> before method invoke");
            Object res = method.invoke(this.proxy);
            System.out.println(">>>> after method invoke");
            return res;
        }
    }

    public static Object agent(Class interfaceClazz, Apple proxy){
            return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                    new Class[] {interfaceClazz}, new MyHandler(proxy) );
    }

}
