package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * create by ljs on 2020/6/9 22:24
 *
 * description:  两个线程打印日期
 *
 */
public class ThreadLocalUsage00 {


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                String s = new ThreadLocalUsage00().date(10);
                System.out.println(s);

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                String s = new ThreadLocalUsage00().date(123);
                System.out.println(s);

            }
        }).start();




    }


    public String date(int seconds) {


        Date date = new Date(seconds*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");
        return dateFormat.format(date);

    }




}
