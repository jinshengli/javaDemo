package thread.objectwaitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by ljs on 2020/6/28 9:41
 * <p>
 * description:  通过两个线程打印 1-10 ；
 *
 *      通过 reentrantLock 来实现 休眠和唤醒
 *      Condition
 *      await(); signal();
 *
 */
public class OddEventPrintReentrantLock {


    private Integer i = 1;
    private ReentrantLock  lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     *  打印1-10的奇数;
     *
     *  判断i 是不是奇数；奇数，打印，唤醒偶数线程；不是奇数，线程进入等待
     */
    public void printOdd() {

        while ( i <= 100 ) {

            lock.lock();
            try {

                if ( i % 2 == 1 ) {
                    System.out.println("奇数：" + i++);
                    condition.signal();
                } else {

                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * 打印偶数方法。
     */
    public void printEvent() {

        while ( i <= 100 ) {

            lock.lock();
            try {

                if ( i % 2 == 0 ) {
                    System.out.println("偶数：" + i++);
                    condition.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {

                lock.unlock();

            }
        }
    }


    public static void main(String[] args) {

        OddEventPrintReentrantLock oddEventPrint = new OddEventPrintReentrantLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEventPrint.printOdd();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEventPrint.printEvent();
            }
        });


        thread.start();
        thread1.start();


    }


}
