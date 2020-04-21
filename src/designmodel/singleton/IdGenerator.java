package designmodel.singleton;

import java.util.concurrent.atomic.AtomicLong;

/***
 *  单例的id 生成器。
 *
 *  饿汉式单例
 *
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){ }

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }


}
