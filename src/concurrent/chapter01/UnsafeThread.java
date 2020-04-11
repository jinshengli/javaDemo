package concurrent.chapter01;


/**
 *
 * 启动两个线程： 都是对同一变量  + 1, 执行10K次。
 *
 * 思考： 下面程序为什么会 < 20K呢？
 *
 * 1）可见性： count 变量会被线程读取到cpu缓存中，cpu计算时从中获取值，
 *     两个cpu 可能在不同cpu执行，缓存也不同。
 *
 * 2）原子性：count ++， 不是原子操作。转换cpu指令至少3条。
 *      （1） 从内存读取值到cpu的寄存器
 *      （2） 在寄存器中 + 1
 *      （3） 将结束写回内存或者cpu缓存
 *
 *      任何一条CPU 指令执行完，操作系统都可以进行任务切换。就可能在其它线程中把共享变量的值修改了。
 *
 *   原子性：我们把一个或者多个操作在 CPU 执行的过程中不被中断的特性称为原子性。
 *
 * 3）编译优化带来的有序性问题
 *      编译器为了优化性能，有时候会改变程序中语句的先后顺序。
 *
 *
 *    经典例子是双重检查的单例。
 *
 *    在 new Singleton() 进行指令重排了， 比如 先分配内存，给引用赋值，这时instance 不为null,
 *     但是还没初始化。 这时，另外一个线程执行getInstance方法， 判断instance 不为null。执行了
 *     可能会发生空指针异常。
 *
 */

class Singleton {
    static Singleton instance;
    static Singleton getInstance(){
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}


public class UnsafeThread {

    private long count = 0;

    private void add10k(){

        int idx = 0;

        while (idx ++ < 10000 ){
            count ++;
        }
    }

    public static long calc() throws InterruptedException {

        final UnsafeThread test = new UnsafeThread();

        Thread th1 = new Thread( () -> {
            test.add10k();
        });


        Thread th2 = new Thread( ()->{
           test.add10k();
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        return test.count;
    }

    public static void main(String[] args) throws InterruptedException {
        long calc = UnsafeThread.calc();
        System.out.println(calc);
    }

}
