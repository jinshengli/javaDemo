package thread.stopthread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Thread.interrupted() 静态方法， 判断当前调用线程的中断标识,将目前线程的中断标识返回, 并且清除中断标识
 *
 */

public class InterruptedDemo extends Thread{

    public Lock lock = new ReentrantLock();

    @Override
    public void run() {



        while (true){

        }



    }

    public static void main(String[] args) {



        InterruptedDemo interruptedDemo = new InterruptedDemo();

        interruptedDemo.start();

        interruptedDemo.interrupt();  // 设置子线程的中断标识； false

        System.out.println(interruptedDemo.isInterrupted());  //判断子线程的中断标识： false

        System.out.println(interruptedDemo.interrupted());  //判断子线程的中断标识 false; 并且设置为true
        System.out.println(Thread.interrupted());  // 判断主线程的中断标识 true, 并且设置为 false
        System.out.println(interruptedDemo.isInterrupted()); // 判断子线程的中断标识，true

    }
}
