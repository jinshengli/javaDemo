### 线程池


##### 使用类 ThreadPoolExecutor创建线程池


##### 创建线程池的几个参数

1. coreSize

    线程池中最少运行的线程数
    
2. maxmumiSize

    线程池中最多可运行的线程数
    
3. keepAlive 、、

    线程数大于coreSize时，空闲的线程可以存活的时间
    
4. 阻塞队列
    
    线程池中的核心线程都在工作时，新的任务会被放到
    队列队列中。
    
5. 线程工厂
    
5. 拒绝策略

    当线程池中的阻塞队列满了，并且已经达到最大线程数，线程
    池处理不了更多的请求，会执行拒绝策略
    
    1）将新任务丢弃
    
    2）将最老未执行的任务丢弃
    
    3）由任务提交线程执行该任务
    
    4）抛出异常


     public ThreadPoolExecutor(int corePoolSize,
                                  int maximumPoolSize,
                                  long keepAliveTime,
                                  TimeUnit unit,
                                  BlockingQueue<Runnable> workQueue,
                                  ThreadFactory threadFactory,
                                  RejectedExecutionHandler handler) {
            if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
                throw new IllegalArgumentException();
            if (workQueue == null || threadFactory == null || handler == null)
                throw new NullPointerException();
            this.acc = System.getSecurityManager() == null ?
                    null :
                    AccessController.getContext();
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.workQueue = workQueue;
            this.keepAliveTime = unit.toNanos(keepAliveTime);
            this.threadFactory = threadFactory;
            this.handler = handler;
        }
    


