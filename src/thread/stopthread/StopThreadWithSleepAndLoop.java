package thread.stopthread;

/**
 * 1、每一次循环都有阻塞，该如何中断？
 *
 * 简单地，将整个while 用try ... 包括， catch 异常。但是一般不这么做。
 *
 * 2、如果你在while内try ... catch 异常，程序只会抛出一个InterruptedException, 继续循环。不会中断。
 *
 * 原因：
 *
 *  sleep 接受到中断后，抛出中断异常，同时清除该线程的中断标识。 catch异常后，线程继续循环操作。
 *
 *
 *  演示：
 *
 *      可中断的线程，在接受到interrupt信号后，通过catch中断异常后，当前线程的中断标识被清除。
 *
 *      这样不能成功中断该线程
 *
 *
 */

public class StopThreadWithSleepAndLoop {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {

            int num = 0;
            while ( num < 10000 && ! Thread.currentThread().isInterrupted() ){

                if ( num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                num++;
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();


    }
}
