package thread.stopthread;

/**
 *  两种中断线程的处理方法。
 *
 *  原理： 使用interrupt 来通知中断，而不是强制。
 *
 *  可响应中断函数在响应中断后，抛出异常，并且清除了标志位。 我们需要手动设置中断标志+判断中断，
 *  或者直接结束线程
 *
 *  1. 在子方法中断，将中断抛出，不要吞掉，try - catch 中断异常。 [中断传递]
 *  2. 在一些不能抛出中断异常，或者不想中断[中断不能传递]， 手动恢复中断。
 *
 *  演示了两种中断方式。
 *
 */

public class RightWayStopThreadPro implements Runnable{
    @Override
    public void run() {

        while (true && !Thread.currentThread().isInterrupted()){   // 判断当前线程的中断信号。

            System.out.println("niu bi");

            try {

                throwMethod();

            } catch (InterruptedException e) {

                System.out.println("执行中断前操作。。。");
                System.out.println("打印日志。。。");
                e.printStackTrace();
                // break;
                Thread.currentThread().interrupt(); // 恢复中断。

            }
        }

    }

    private void throwMethod() throws InterruptedException {  // 向上传递中断。
        // 这个方法的异常，子方法不要吞掉中断异常，传递中断。
        Thread.sleep(10000);
    }

    public static void main(String[] args) throws InterruptedException {

        RightWayStopThreadPro rightWayStopThreadPro = new RightWayStopThreadPro();
        Thread thread = new Thread(rightWayStopThreadPro);

        thread.start();
        Thread.sleep(2000);

        thread.interrupt();  // 调用方发出中断信号。

    }
}
