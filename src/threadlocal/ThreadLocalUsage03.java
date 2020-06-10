package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by ljs on 2020/6/9 22:24
 *
 * description:  1000个任务；通过线程池来完成
 *
 * 各个线程公用一个SimpleDateFormat;
 * 但是SimpleDateFormat不是线程安全的；需要锁辅助；
 *
 * 缺点：性能问题；
 *
 *
 *
 */
public class ThreadLocalUsage03 {


    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");
    public static void main(String[] args) {


        for ( int i = 0; i < 1000; ++i ){

            int fl = i;

            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String s = new ThreadLocalUsage03().date(fl);
                    System.out.println(s);
                }
            });
        }

        threadPool.shutdown();


    }


    public String date(int seconds) {
        Date date = new Date(seconds*1000);
        String s = null;

        synchronized (ThreadLocalUsage03.class){
            s = dateFormat.format(date);
        }

        return s;
    }




}
