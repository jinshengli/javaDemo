package designmodel.singleton;


import java.util.concurrent.atomic.AtomicLong;

/**
 *  静态内部类实现单例。
 *
 *  利用java的静态内部类，将这个静态内部类设置为private，只能是类内可以访问到。
 *  静态内部类里面的静态变量只会随类加载一次，需要设置它不能被类外修改。
 *
 *  特点：有点类似懒汉式，延迟加载。
 *
 *  SingletonHolder 才会被加载，这个时候才会创建 instance。instance 的唯一性、创建过程的线程安全性，都由
 * JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 *
 */
public class IdGeneratorStaticClass {

    private AtomicLong atomicLong = new AtomicLong(0);

    private IdGeneratorStaticClass() {}

    public IdGeneratorStaticClass getInstance(){
        return SingletonHolder.instance;
    }
    private static class SingletonHolder{
        private static final IdGeneratorStaticClass instance = new IdGeneratorStaticClass();
    }

    public Long getId(){
        return atomicLong.getAndIncrement();
    }



}
