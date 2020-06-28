package thread.objectwaitnotify;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * create by ljs on 2020/6/28 10:53
 * <p>
 * description: 演示 CyclicBarrier的用法
 *
 *  用法：让一组线程等待至【某一状态】；再一同时执行
 *
 *  比如：如同 100米短跑比赛，所有的选手做好准备，并且等待裁判的指令，
 *
 *  再同时出发。
 *
 *
 */
public class CyclicBarrierDemo {


    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    /**
     *
     */
    public void race() {

        String name = Thread.currentThread().getName();
        System.out.println( name + "做拉伸准备。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cyclicBarrier.await();// 等待所有人都准备好了，
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(name + "起跑了。。" + new Date().getTime());

    }


    public static void main(String[] args) {

        CyclicBarrierDemo barrierDemo = new CyclicBarrierDemo();

        for (int i =0; i < 4; ++i  ) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    barrierDemo.race();
                }
            }, "选手" + i).start();

        }


    }




}
