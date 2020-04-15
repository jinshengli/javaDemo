package thread.stopthread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Thread.interrupted() 静态方法， 判断当前调用线程的中断标识【返回】, 并且清除中断标识
 *
 */

public class InterruptedDemo extends Thread{

    @Override
    public void run() {
        while (true){

        }
    }

    Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        InterruptedDemo interruptedDemo = new InterruptedDemo();

        interruptedDemo.start();

        interruptedDemo.interrupt();

        System.out.println(interruptedDemo.isInterrupted());



        System.out.println(interruptedDemo.interrupted());

        System.out.println(Thread.interrupted());

        System.out.println(interruptedDemo.isInterrupted());

    }
}
