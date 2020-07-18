package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * create by ljs on 2020/6/12 8:37
 * <p>
 * description: 自定义线程池
 *
 *
 *
 *
 */
public class CustomerThreadPool {


    private static final int corePoolSize = 5;
    private static final int maxiMumPoolSize = 10;
    private static final int queueCapacity = 100;
    private static final Long keepAliveTime = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxiMumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++ ){
            MyRunnable worker = new MyRunnable("x" + i);
            executor.submit(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()){

        }

        System.out.println("finished all threads");


    }


}
