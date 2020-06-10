package concurrent.chapter02;


import java.util.concurrent.Semaphore;

/**
 *  信号量：解决多个线程可以访问临界区的问题。
 *
 *
 *
 *
 *
 */
public class SemaphoreDemo {


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10);

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();


    }
}
