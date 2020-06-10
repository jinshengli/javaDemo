package threadpool;


import java.util.concurrent.*;

public class FutureTaskDemo{

    public static void test(){

        FutureTask<Integer> futureTask = new FutureTask<>( ()-> 1+2);

        Thread T1 = new Thread(futureTask);

        T1.start();

        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(2);

        T2Task t2Task = new T2Task();

        FutureTask futureTask2 = new FutureTask(new T2Task());

        FutureTask futureTask1 = new FutureTask(new T1Task(futureTask2));

        Future<String> submit = (Future<String>) service.submit(futureTask1);
        Future<String> submit1 = (Future<String>) service.submit(futureTask2);


        System.out.println(submit.get());
        System.out.println(submit1);


    }

}


class T1Task implements Callable<String>{

    FutureTask futureTask;

    public T1Task(FutureTask task){
        this.futureTask = task;
    }



    @Override
    public String call() throws Exception {

        System.out.println("T1: 洗水壶");

        TimeUnit.SECONDS.sleep(1);

        System.out.println("T1: 烧水");

        TimeUnit.SECONDS.sleep(15);

        String o = (String) this.futureTask.get();


        System.out.println("拿到了茶：" + o);
        System.out.println("泡茶");

        return "好茶。。。。";

    }
}


class T2Task implements Callable<String>{

    @Override
    public String call() throws Exception {

        System.out.println("T2: 洗茶壶");
        Thread.sleep(1000);

        System.out.println("T2: 洗茶杯");
        Thread.sleep(2000);

        System.out.println("T2： 那茶叶");

        TimeUnit.SECONDS.sleep(1);

        return "龙井";
    }
}
