package concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *  LinkedBlockingQueue 源码解析
 *
 *  底层是链表组成，有两把锁，两个个条件变量
 *  putLock: 在有元素入队时，需要获得锁。
 *  takeLock: 在元素出队时，需要获得锁。
 *
 *  一个条件变量对应一个等待队列，专门存放需要改条件变量的线程。
 *
 *  Wait queue for waiting takes
 *  notEmpty = takeLock.newCondition(); notEmpty 的队列不空的条件变量，对应有一个等待队列，专门存放出队的线程的，需要被唤醒。
 *
 *  Wait queue for waiting puts
 *  notFull = putLock.newCondition(); notFull 对应有一个等待队列，专门存放入队的线程的，这些线程等待被唤醒。
 *
 *
 *  关于阻塞队列的两个方法 put, take。
 *
 *  put方法流程：
 *  1、 上锁: putLock.lockInterruptibly(); 确保每次都只有一个线程进行入队【put】操作。
 *  2、 判断队列是否已经满了， 满了，需要阻塞、放弃putLock锁。 放到放到 notFull对应的等待队列上，等待。需要循环等待，
 *      【因为你被唤醒了，但是不一定马上被调动了，等到你再次执行时，队列不一定是notFull了】
 *  3、等待到了队列notFull 了， 入队，链表末尾添加一个node.。
 *  4、判断队列是否还有剩余容量，有的话，notFull.signal(), 唤醒在notFull对应的等待队列。
 *
 *  5、解锁 putLock.unLock()。
 *
 *  6、最后判断队列在 入队前 是否为空？
 *
 *        c = count.getAndIncrement(); c = count++; 获取值再加一
 *
 *       if (c == 0)
 *             signalNotEmpty();
 *
 *     这个代码其实是困惑了我很久， 因为我吊，想不通c啥时候为0,区别：incrementAndGet()
 *
 *     为啥要这个判断？
 *     c == 0； 代表队列为空，take的线程都被阻塞了，这时需要唤醒所用take的线程。
 *
 *
 *  take: 出队，队列空，阻塞到不空。
 *
 *  1、上锁。takeLock
 *  2、判断队列是否为空，空就进入等待，等到到队列不空 notEmpty。
 *  3、出队。
 *  4、判断队列还可以出队，可以的话，继续唤醒 在notEmpty上的等待线程。
 *  5、解锁
 *  6、判断 出队前 是否是满的？ 满的话
 *      唤醒在notFull上的等待的线程，notFull.signal()
 *
 *
 *
 *
 *
 *
 *
 */

public class LinkedBlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {


        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);


//        blockingQueue.add(1);
//
//        blockingQueue.offer(3);

        blockingQueue.put(1);

//        blockingQueue.peek();
//
//        blockingQueue.poll();

        blockingQueue.take();





    }

}
