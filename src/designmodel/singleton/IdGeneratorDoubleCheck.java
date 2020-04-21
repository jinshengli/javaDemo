package designmodel.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * 双重检查锁的单例模式
 *
 * 提高并发度，不用每次获取单例都要blocking线程。 这种实现方式解决了懒汉式并发度低的问题。
 *
 *  网上有很多观点是 instance 对象需要标注volatile, 禁止指令重排序； 这应该不会发生的。 应为在初始化时还没退出锁？
 *
 *  【在赋值给instance时， 实例还没初始化化。】 这个问题在JDK高版本中不太会发生。
 *
 * （ 解决的方法很简单，只要把对象 new 操作和初始化操作
 * 设计为原子操作，就自然能禁止重排序）
 *
 */

public class IdGeneratorDoubleCheck {

    private AtomicLong atomicLong = new AtomicLong(0);
    private IdGeneratorDoubleCheck instance;
    private IdGeneratorDoubleCheck() {}
    public IdGeneratorDoubleCheck getInstance(){
        if ( instance == null ){
            synchronized (IdGeneratorDoubleCheck.class){   // 此处为类级别的锁
                if ( instance == null )  // 再次判断，为了在这个锁上等待的线程进入之后，判断是否已经创建了单例、
                    instance = new IdGeneratorDoubleCheck();
            }
        }
        return instance;
    }
    public Long getId(){
        return atomicLong.incrementAndGet();
    }
}
