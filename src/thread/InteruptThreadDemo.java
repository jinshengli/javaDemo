package thread;

public class InteruptThreadDemo {
    static class TaskDemo implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + "is running");
                System.out.println(Thread.currentThread().getName() + "is running");
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
