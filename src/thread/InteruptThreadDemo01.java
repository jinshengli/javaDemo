package thread;

public class InteruptThreadDemo01 {
    static class TaskDemo implements Runnable{
        volatile Boolean exit = false;
        @Override
        public void run() {
            while (!exit){
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
        taskDemo.exit = true;
    }

}
