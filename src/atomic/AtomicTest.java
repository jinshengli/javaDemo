package atomic;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest implements Runnable{


    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static Integer s = 0;


    public  void atomicAddIncrement(){
        atomicInteger.incrementAndGet();
    }

    public synchronized void AddInteger(){
        s = s + 1;
    }


    @Override
    public void run() {
        for (int i=0; i < 100000; ++i ){
            atomicAddIncrement();
            AddInteger();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new AtomicTest());
        Thread thread1 = new Thread(new AtomicTest());

        thread.start();
        thread1.start();



        thread.join();
        thread1.join();
        System.out.println(atomicInteger.get());
        System.out.println(s);



    }

}
