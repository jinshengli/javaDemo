package threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {



    public static void main(String[] args) throws ExecutionException, InterruptedException {



        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        FutureTask futureTask = new FutureTask(new Callable() {

            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                return "我是子线程" + Thread.currentThread().getName();
            }
        });


        Future<?> f = executor.submit(futureTask);


        String result = (String) f.get();

        System.out.println(result);





    }


}
