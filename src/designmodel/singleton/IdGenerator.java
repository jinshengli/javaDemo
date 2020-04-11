package designmodel.singleton;

import java.util.concurrent.atomic.AtomicLong;

/***
 *  单例的id 生成器。
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){ }

    private static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }


}
