package thread.stopthread;


/**
 *  没有阻塞的线程，如何中断？
 *
 *  判断中断标识位。Thread.currentThread().isInterrupted()
 *
 */

public class StopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {

        int num = 0;
        while ( !Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE / 2 ){
            if ( num % 10000 == 0 ){
                System.out.println(num + "是10000的倍数");
            }
            num ++;
        }

    }


    public static void main(String[] args) throws InterruptedException {

        StopThreadWithoutSleep threadWithoutSleep = new StopThreadWithoutSleep();

        Thread thread = new Thread(threadWithoutSleep);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();

    }
}
