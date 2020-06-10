package threadpool;

import java.util.concurrent.*;

public class FixedThreadPoolTest {

    private static ExecutorService executorService =
            Executors.newFixedThreadPool(4);


    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    ScheduledExecutorService sechedule = Executors.newScheduledThreadPool(3);




//    ExecutorService newFixThreadPool


    public void secheduleTest(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("xxx");
            }
        };

        sechedule.scheduleAtFixedRate(runnable, 3, 6, TimeUnit.SECONDS);


    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i=0; i < 10000; ++i ){
            //executorService.execute(new Task());
            //Future<?> submit = executorService.submit(new Task());

        }



    }


    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("thread" + Thread.currentThread());

        }
    }


}
