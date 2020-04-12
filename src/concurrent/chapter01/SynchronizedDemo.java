package concurrent.chapter01;


/**
 *  va 编译器会在 synchronized 修饰的方法或代码块前后自动加上加锁
 * lock() 和解锁 unlock()，这样做的好处就是加锁 lock() 和解锁 unlock() 一定是成对出现的。
 */


/**
 * 管程中锁的规则：对一个锁的解锁 Happens-Before 于后续对这个锁的加
 * 锁。
 */

/**
 * synchronized 修饰的临界区是互斥的，也就是说同一时刻只有一个线程执行临界区的代
 * 码；而所谓“对一个锁解锁 Happens-Before 后续对这个锁的加锁”，指的是前一个线程
 * 的解锁操作对后一个线程的加锁操作可见，综合 Happens-Before 的传递性原则，我们就
 * 能得出前一个线程在临界区修改的共享变量（该操作在解锁之前），对后续进入临界区
 * （该操作在加锁之后）的线程是可见的
 */


public class SynchronizedDemo {

    // 锁定非静态代码块；默认锁定当前对象。
    synchronized void foo(){
        // 临界区
    }


    // 锁定静态方法；默认锁定当前class 对象 【SysnchronizedDemo.class】
    synchronized static void bar(){
        // 临界区
    }



    Object obj = new Object(); // 定义obj一把锁
    void baz(){

        // 锁定代码区  锁定obj对象
        synchronized (obj){
            // 临界区
        }

    }




}
