package thread.objectwaitnotify;

/**
 * create by ljs on 2020/6/28 9:41
 * <p>
 * description:  通过两个线程打印 1-10 ；
 */
public class OddEventPrint {


    private Integer i = 1;
    private Object object = new Object();

    /**
     *  打印1-10的奇数方法；由打印奇数线程调用。
     *
     *  判断i 是不是奇数；奇数，打印，唤醒偶数线程；不是奇数，线程进入等待
     */
    public void printOdd() {

        while ( i <= 10 ) {

            synchronized (object) {

                if ( i % 2 == 1 ) {
                    System.out.println("奇数：" + i++);
                    object.notify();  // 唤醒一个线程
                } else {
                    try {
                        object.wait(); // 进入休眠状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * 打印偶数方法。由打印偶数线程调用
     */
    public void printEvent() {

        while ( i <= 10 ) {
            synchronized ( object ) {

                if ( i % 2 == 0 ) {
                    System.out.println("偶数：" + i++);
                    object.notify();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


    public static void main(String[] args) {

        OddEventPrint oddEventPrint = new OddEventPrint();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEventPrint.printOdd();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEventPrint.printEvent();
            }
        });

        thread.start();
        thread1.start();


    }


}
