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
 * 使用ThreadLocal为每个线程保存一个 SimpleDateFormat; 线程隔离
 *
 * 空间换时间
 *
 *
 */
public class ThreadLocalUsage04 {


    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {


        for ( int i = 0; i < 1000; ++i ){

            int fl = i;

            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String s = new ThreadLocalUsage04().date(fl);
                    System.out.println(s);
                }
            });
        }

        threadPool.shutdown();


    }


    public String date(int seconds) {
        Date date = new Date(seconds*1000);

        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();

        String format = simpleDateFormat.format(date);

        return format;
    }




}

class ThreadSafeFormatter{

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue() {
            // ThreadLocal 初始化的一种方式。
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };






}
