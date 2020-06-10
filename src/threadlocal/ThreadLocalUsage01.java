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
 *
 *
 */
public class ThreadLocalUsage01 {


    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {


        for ( int i = 0; i < 1000; ++i ){

            int fl = i;

            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String s = new ThreadLocalUsage01().date(fl);
                    System.out.println(s);
                }
            });
        }

        threadPool.shutdown();


    }


    public String date(int seconds) {
        Date date = new Date(seconds*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");
        return dateFormat.format(date);
    }




}
