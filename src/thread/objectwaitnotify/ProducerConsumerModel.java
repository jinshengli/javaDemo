package thread.objectwaitnotify;




import java.util.Date;
import java.util.LinkedList;

/**
 *  使用wait、notify 模拟 作出生产者和消费者模式
 *
 *  包含三部分：
 *
 *  模拟，阻塞队列storage：里面使用 wait, notify。  每次只能有一个线程操作，入队或者出队
 *
 *  生产者：生成 storage.put(Object o) 当队列满了，自动阻塞。 等待至队列不满
 *  消费者：消费 storage.take()  队列空，阻塞，等待至队列不空。
 *
 *
 */


public class ProducerConsumerModel {

    public static void main(String[] args) {

        EventStorage storage = new EventStorage();

        Thread producer = new Thread(new Producer(storage));

        Thread consumer = new Thread(new Consumer(storage));

        producer.start();
        consumer.start();
    }


    static class Producer implements Runnable{
        private EventStorage storage;
        public Producer(EventStorage storage) {
            this.storage = storage;
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; ++i ){
                this.storage.put();
            }
        }
    }

    static class Consumer implements Runnable{

        EventStorage storage;
        public Consumer(EventStorage storage) {
            this.storage = storage;
        }
        @Override
        public void run() {
            while (true){
                this.storage.take();
            }
        }
    }



    static class EventStorage{
        private int maxSize;
        private LinkedList<Date> storage;
        public EventStorage(){
            maxSize = 10;
            storage = new LinkedList<>();
        }

        public synchronized void put() {
            while (storage.size() == maxSize ){
                try {
                    wait(); // 等待到队列不满 NOT FULL
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.println("仓库有了"+storage.size() + "个产品");
            notify();
        }

        public synchronized void take(){
            while (storage.size() == 0 ){
                try {
                    wait();  // 等待到队列不空 NOT EMPTY
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("拿到了" + storage.poll() + "产品");
            notify();
        }
    }


}
