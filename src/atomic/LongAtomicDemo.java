package atomic;

import java.util.concurrent.atomic.*;

public class LongAtomicDemo {

    private final AtomicLong count = new AtomicLong(0);


    public long getCount(){
        return count.get();
    }

    public void service(){
        long l = count.incrementAndGet();
        System.out.println(l);
    }

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        atomicInteger.getAndIncrement();
        atomicInteger.incrementAndGet();


    }


}
