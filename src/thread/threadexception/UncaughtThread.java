package thread.threadexception;


/**
 *
 * 定义全局的线程异常处理
 *
 */

public class UncaughtThread implements Runnable{


    public static void main(String[] args) throws InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        UncaughtThread u = new UncaughtThread();

        new Thread(u).start();
        Thread.sleep(1000);
        new Thread(u).start();

        for (int i = 0; i < 1000; ++i )
            System.out.println(i);


    }

    @Override
    public void run() {

        throw new RuntimeException("我去");
    }
}
