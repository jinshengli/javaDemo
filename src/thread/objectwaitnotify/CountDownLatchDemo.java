package thread.objectwaitnotify;

import java.util.concurrent.CountDownLatch;

/**
 * create by ljs on 2020/6/28 10:20
 * <p>
 * description:   演示CountDownLatch的用法
 *
 * 1. CountDownLatch能够让一个线程等待一组线程执行完后，才执行。
 *
 *      等待一组线程
 * 例子：
 *     一辆汽车等待所有的游客上车后；发车
 *
 *
 */
public class CountDownLatchDemo {


    private CountDownLatch count = new CountDownLatch(3);

    /**
     *  游客 上车过程; 有游客线程调用
     */
    public void visitor() {

        String name = Thread.currentThread().getName();
        System.out.println("开始上车: " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已经上车完毕: " + name);
        count.countDown();
    }

    /**
     *  车；
     */
    public void car() {

        String name = Thread.currentThread().getName();
        System.out.println("等待开车中。。。" + name);
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开车。。。" + name);
    }


    public static void main(String[] args) {

        CountDownLatchDemo downLatchDemo = new CountDownLatchDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                downLatchDemo.car();
            }
        }, "汽车线程").start();

        for ( int i = 0; i  < 100; ++i ) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    downLatchDemo.visitor();
                }
            }, "游客" + i).start();

        }








    }


}
