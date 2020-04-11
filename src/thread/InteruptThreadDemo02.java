package thread;

public class InteruptThreadDemo02 {
    static class TaskDemo implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println(Thread.currentThread().getName() + "is running");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //  捕获中断， 清除中断信号。
                    // 退出线程。
                    System.out.println("捕获中断");
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TaskDemo taskDemo = new TaskDemo();
        Thread myThread = new Thread(taskDemo);
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();


    }

}
