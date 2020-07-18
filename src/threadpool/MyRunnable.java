package threadpool;

import java.util.Date;

/**
 * create by ljs on 2020/6/12 8:38
 * <p>
 * description:
 */
public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name){
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
