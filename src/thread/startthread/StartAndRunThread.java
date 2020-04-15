package thread.startthread;

/**
 *
 *一：启动一个新线程的正确方式？ start()
 *
 * start() 源码
 *
 * 1、首先会检查线程的状态，只有在NEW状态下的才会继续执行。否者抛出IllegalThreadStateException。
 * 2、加入线程组
 * 3、调用start0()方法
 *
 * 二：重复调用start() 会怎样？ 抛出异常。
 *
 */
public class StartAndRunThread {


    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };


        Thread thread = new Thread(runnable);

        thread.start(); // 新启动一个线程
        thread.run();  //  运行的是一个实例的普通方法。

        thread.start();
    }


}
