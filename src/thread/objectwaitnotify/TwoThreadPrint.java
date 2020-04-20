package thread.objectwaitnotify;

/**
 *
 *  两个线程交替打印1-100的数。
 *
 *  1，一个线程打印完，唤醒其他线程，wait自己。
 *
 *
 */

public class TwoThreadPrint {

    private static int count = 0;

    private static Object lock = new Object();

    static class PrintTask implements Runnable{

        @Override
        public void run() {
                while ( count <= 100 ){
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        lock.notify();
                        if ( count <= 100 ){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
    }


    public static void main(String[] args) throws InterruptedException {


        PrintTask printTask = new PrintTask();

        Thread thread = new Thread(printTask);

        Thread thread1 = new Thread(printTask);

        thread.start();
        Thread.sleep(2000);
        thread1.start();



    }




}
