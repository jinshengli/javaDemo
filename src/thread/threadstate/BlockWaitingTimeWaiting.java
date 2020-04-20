package thread.threadstate;


/**
 *  演示线程的block、waiting_timed、waiting 的状态
 */

public class BlockWaitingTimeWaiting implements Runnable{

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws InterruptedException {

        BlockWaitingTimeWaiting runnable = new BlockWaitingTimeWaiting();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        Thread.sleep(100);
        System.out.println(thread1.getState());  // TIMED_WAITING

        /**
         *    thread1 在调用 Thread.sleep() 方法，在进入timed_waiting状态
         *    它经过指定时间再能自动唤醒
          */


        System.out.println(thread2.getState());  //  BLOCKED

        /**
         *   thread2 在等待获取synchronized锁，会进入block状态
         */

        Thread.sleep(1300);

        System.out.println(thread1.getState()); //WAITING
        /**
         *  thread1 这是执行wait()， 进入waiting 状态，并且释放synchronized锁
         */

        System.out.println(thread2.getState()); // TIMED_WAITING
        /**
         * thread2 获得synchronized 锁之后，指定Thread.sleep(),进入Timed_waiting.
         */

    }

}
