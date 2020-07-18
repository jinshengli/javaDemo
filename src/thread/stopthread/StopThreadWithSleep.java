package thread.stopthread;

/**
 *
 *  不在while循环中的阻塞。
 *
 *  可以简单捕获异常， 但是还是有问题的。没有马上中断的，
 *
 */

public class StopThreadWithSleep {


    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            while (num <= 3000000 && !Thread.currentThread().isInterrupted()){

                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num ++;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.interrupted();
            }

            System.out.println("sleep 后");


        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

}
