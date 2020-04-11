package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicApiDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while ( ! Thread.currentThread().isInterrupted() ){
                    int i = atomicInteger.incrementAndGet();
                    System.out.println( " 当前值为： " +  i);
                }
                System.out.println("开始退出线程：+" + Thread.currentThread().getName());
            }
        });


        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    System.out.println("开始预期进程");
                    int i = atomicInteger.get();
                    atomicInteger.compareAndSet(i, -1);
                    if ( atomicInteger.get() == -1 ){
                        System.out.println("atomicInteger = 1 ....  退出 " + Thread.currentThread().getName());
                        break;
                    }
                }
                System.out.println("准备结束线程：" + Thread.currentThread().getName() );
                thread1.interrupt();
            }
        });


        thread1.start();
        thread.start();


        int i = atomicInteger.get();
        System.out.println(i);

        int i1 = atomicInteger.incrementAndGet();
        System.out.println(i1);

        boolean b = atomicInteger.compareAndSet(1, 2);
        System.out.println(b);

        int andSet = atomicInteger.getAndSet(100);
        System.out.println(andSet);

        System.out.println(atomicInteger.get());

    }

}
