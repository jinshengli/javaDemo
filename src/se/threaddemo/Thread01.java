package se.threaddemo;

public class Thread01 extends Thread {

    @Override
    public void run() {

        for ( int i = 0; i < 100; ++i ){
            System.out.println("1-20");
        }
    }

    public static void main(String[] args) {

        Thread01 thread01 = new Thread01();

        Task task = new Task();

        Thread mythread = new Thread(task);

        thread01.start();
        mythread.start();


    }


}


class Task implements Runnable{

    @Override
    public void run() {
//        this.sleep("ccc");
//        Thread.sleep(100);
        System.out.println("x----y");
    }
}