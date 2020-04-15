package thread.threadcoreknowle;

/**
 *  实现线程的方法一：
 *
 *  实现Runnable 接口。 优先使用这种方式
 *
 *    What will be run.
 *
 *
 *    Thread.run() 源码
 *    target 代表传入的Runnable对象
 *     @Override
 *      public void run() {
*             if (target != null) {
*                 target.run();
*             }
 *     }
 */

public class RunnableStyle implements Runnable{

    public static void main(String[] args) {

        /**
         *  传入Runnable 类型对象， 在Thread 类里
         *
         *
         *
         */
        Thread thread =  new Thread(new RunnableStyle());

        thread.start();
    }

    @Override
    public void run() {

        System.out.println("Runnable");
    }
}
