package concurrent.chapter01;


import java.util.List;

/**
 *
 *  等待-通知的机制。  利用 synchronized + wait + notify + notifyAll 实现
 *
 *  你需要明白 还有在锁上的等待队列。  等待的好处：在某个线程需要获取特定资源时,才能进行下一步操作。 资源是啥？【 例子中两把对象锁 】
 *
 *  1，循环等待   while ( als.contains(from) || als.contains(to) ) ;  这样消耗cpu 资源。
 *  2. while（不满足条件）{
 *      wait()；
 *  }
 *
 *  不满足条件，进入等待状态【阻塞状态】
 *
 *
 * notify 会通知在当前锁上 等待队列中的某个【随机】线程。
 * notifyAll 会通知等待队列中的所有线程。
 *
 *
 *
 */


public class WaitNotifyDemo {



}


class Acount{

    private Allocator allocator; // 单例
    private int balance;
    void transfer(Acount target, int amt ){

        allocator.apply(this, target);
        try {
            // 锁定转出账号
            synchronized (this){
                synchronized (target){
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }

            }
        }finally {
            allocator.free(this, target);
        }
    }

}


class Allocator{

    private List<Object> als;

    // 经典写法， 申请两个资源。

    // 这里有this 锁， 线程安全的操作 als数组。 这是 一把相当大的锁，管理。。。
    synchronized void apply(Object from, Object to){

        while ( als.contains(from) || als.contains(to) ){  // 代表被其他线程占用，就进入等待队列

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("这时候有其它线程 notify，通知其它线程了");

        }
        // wait() 结束的前提，from，to 这两资源不被其他占用。
        als.add(from);
        als.add(to);
    }

    synchronized void free(Object from, Object to){

        als.remove(from);
        als.remove(to);
        notifyAll(); // 通知所有在等待队列上的线程

    }

}