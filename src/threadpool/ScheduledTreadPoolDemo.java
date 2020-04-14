package threadpool;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  延时执行以及周期执行任务。
 *
 *  理解两种方式的周期执行任务的差异。
 *
 *
 */


/**

 public ScheduledThreadPoolExecutor(int corePoolSize) {
     super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
     new DelayedWorkQueue());
 */


public class ScheduledTreadPoolDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd dd:mm:ss");

                try {
                    long start = System.currentTimeMillis();
                    Thread.sleep(3);
                    long end = System.currentTimeMillis();

                    String format = simpleDateFormat.format(new Date(end));
                    System.out.println(format);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

         // rate + 固定。

        /**
         *  你可以将【rate】 解析成比率、速率。 根据这个函数的特点，可以理解为 任务是周期执行的、
         *
         *  一个任务在当前线程池中 同一时间只会有一个线程执行它。
         *
         *  1. 当任务执行时间 < period 周期时间， 按照perioad 的时间间隔启动该任务。
         *  2. 当任务执行时间 > period 时， 等待这个任务执行完，马上启动一个线程执行任务。
         */

        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 3, TimeUnit.SECONDS);

         // 固定延时启动任务 。 到固定时间，任务启动。

        /**
         *  如果当前任务工作时间大于延时工作时间。线程池再启动一个线程执行这个任务、
         *
         *  这样确保了你当前的任务 在一段时间内的执行次数固定。
         *  比如 间隔1分钟执行一次， 无论如何任务是怎样的，都会在一分钟后启动一个线程执行任务。
         *
         */
        scheduledExecutorService.scheduleWithFixedDelay(runnable, 1, 2, TimeUnit.SECONDS);



        }



}




