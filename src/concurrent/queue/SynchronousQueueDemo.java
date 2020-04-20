package concurrent.queue;

import java.util.concurrent.SynchronousQueue;


/**
 *  队列没有容量
 *  put操作要等take操作，就是take操作要等到别人删除了才可以返回
 */


public class SynchronousQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        synchronousQueue.put(12);



    }


}
