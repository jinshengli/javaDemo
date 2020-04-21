package designmodel.singleton;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 懒汉式单例，延迟创建单例。
 *
 * 这是getInstance 使用同步代码块，一次只能有一个线程获取单例引用。
 *
 */
public class IdGeneratorLazy {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private static IdGeneratorLazy idGeneratorLazy;

    private IdGeneratorLazy(){}

    public static synchronized IdGeneratorLazy getInstance(){

        if ( idGeneratorLazy == null ){
            idGeneratorLazy = new IdGeneratorLazy();
        }
        return idGeneratorLazy;
    }

    public Integer generatorId(){
        return atomicInteger.incrementAndGet();
    }
}
