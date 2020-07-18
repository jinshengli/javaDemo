package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  线程池是基于 生成者、消费者模式。
 *
 *  线程池实现线程的复用，管理线程的创建和销毁，避免线程过多耗尽系统资源。
 *
 *  标准线程池的几个重要参数：
 *
 *  核心线程数：corePoolSize
 *
 *  最大线程数：maxinumPoolSize
 *
 *  工作队列： workQueue
 *
 *  keepAliveTime: 空闲的存活时间，当线程数大于核心线程数
 *
 *  threadFactory：通过这个参数你可以自定义如何创建线程，例如你可以给线程指定一个有意义的名字。
 *
 *  handler: 拒绝策略
 *
 *  CallerRunsPolicy：提交任务的线程自己去执行该任务。
 * AbortPolicy：默认的拒绝策略，会throws RejectedExecutionException。
 * DiscardPolicy：直接丢弃任务，没有任何异常抛出。
 * DiscardOldestPolicy：丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入
 * 到工作队列。
 *
 *
 */

public class MyThreadPool {

    BlockingQueue<Runnable> workQueue;
    List<WorkerThread> workThreads = new ArrayList<>();

    /**
     *  构造线程池：线程数 + 任务队列。
     * @param poolSize
     * @param blockingQueue
     */
    public MyThreadPool(int poolSize, BlockingQueue blockingQueue){
        this.workQueue = blockingQueue;

        for (int i = 0; i < poolSize; ++i ){
            WorkerThread thread = new WorkerThread();
            thread.start();
            workThreads.add(thread);
        }
    }

    /**
     *  提交任务，把任务提交到工作队列中去，阻塞队列
     * @param runnable
     */

    void execute(Runnable runnable){
        workQueue.add(runnable);
    }

    /**
     *   每个工作线程的作用：获取一个阻塞队列的任务，然后运行任务。【take.run()】
     */

    class WorkerThread extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Runnable take = workQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        BlockingQueue<Runnable> workeQueue = new LinkedBlockingQueue<>();

        MyThreadPool pool = new MyThreadPool(10, workeQueue);

        pool.execute(()-> {
            System.out.println("hehe");
        });

    }



}
