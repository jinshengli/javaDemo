package designmodel.singleton;


import java.util.concurrent.atomic.AtomicLong;

/**
 * 通过枚举创建单例，枚举本身就是单例的
 */

public enum IdGeneratorEnum {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }


}
