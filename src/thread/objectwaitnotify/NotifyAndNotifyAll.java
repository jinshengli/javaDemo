package thread.objectwaitnotify;

/**
 *  演示notify 和notifyAll 的区别：
 *      notify 会随机唤醒在对象上的wait set中的一个线程。
 *      notifyAll 会唤醒所有在对象上wait set的线程。
 *
 *  wait 和 notify 、notify 执行顺序。 和它们都是在synchronized 的代码块中使用。
 *
 *  被唤醒的线程不会马上被执行，会进入类似entry set中。
 *
 *
 *  wait释放当前对象锁
 *  但是notify 和notifyAll 不会释放当前锁的。
 */


public class NotifyAndNotifyAll implements Runnable{

    private static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 通知线程。
        Thread notifyThread = new Thread(() -> {
            synchronized (resource){
                System.out.println(Thread.currentThread().getName() + "Notify 获得锁");
//                resource.notifyAll();
                resource.notify();
                System.out.println(Thread.currentThread().getName() + "唤醒");
            }

        });

        Runnable runnable = new NotifyAndNotifyAll();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        notifyThread.start();

    }


    @Override
    public void run() {

        synchronized (resource){
            System.out.println(Thread.currentThread().getName() + "获得锁");
            System.out.println(Thread.currentThread().getName() + "wait前");
            try {
                resource.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "再次获得锁");
            System.out.println(Thread.currentThread().getName() + "结束");

        }


    }
}
