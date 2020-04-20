package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 演示重排序
 *
 * “直到达到某个条件才停止”
 *
 *
 *
 *
 *
 */
public class OutOfOrderExecution {

    private static int x =0, y =0;
    private static int a = 0, b=0;

    public static void main(String[] args) throws InterruptedException {

        int i=0;
        while (true){

            CountDownLatch latch = new CountDownLatch(1);

            a = b = x= y = 0;
            i++;

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    a =  1;
                    x = b ;
                }
            });

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            one.start();
            two.start();
            latch.countDown();
            one.join();
            two.join();

            if ( x == 0 && y == 0 ){
                System.out.println( i + "  x=" + x + "  y=" + y);
                break;
            }else {
                System.out.println( i + "  x=" + x + "  y=" + y);
            }



        }



    }

}
