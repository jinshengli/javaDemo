package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    private static ExecutorService executorService =
            Executors.newFixedThreadPool(4);


    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    ExecutorService sechedule = Executors.newScheduledThreadPool(3);




    public static void main(String[] args) {

        for (int i=0; i < 10000; ++i ){
            executorService.execute(new Task());
        }

    }


    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("thread" + Thread.currentThread());
        }
    }


}
