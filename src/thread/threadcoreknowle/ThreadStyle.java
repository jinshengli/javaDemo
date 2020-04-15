package thread.threadcoreknowle;

/**
 *  使用继承Thread 方法实现线程。
 *
 *
 *
 *
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {

        Thread thread =  new ThreadStyle();
        thread.start();
    }


    @Override
    public void run() {
        super.run();
    }
}
