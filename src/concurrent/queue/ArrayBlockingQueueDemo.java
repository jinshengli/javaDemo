package concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 *  ArrayBlockingQueue源码分析
 *
 *  特点：底层是数组，大小在初始化的时候固定，不可变。
 *  1、具有阻塞队列的特点，先进先出。
 *  队列空了，take操作被阻塞，直到队列不空，notEmpty
 *  队列满了，put操作被阻塞，指导队列不满，notFull
 *
 *  你要思考的话，入队、出队时怎么过程。
 *
 *  其实有点像循环队列的意思，将数组重复利用，有几个变量需要注意
 *
 *  putIndex: 代表的是当前入队的位置， 当 ++putIndex == item.length，代表已经到数组的末尾了，那么将putIndex = 0; 循环。
 *  tackIndex: 代表的是当前出队的位置，当   if (++takeIndex == items.length);   takeIndex = 0;
 *  count: 代表队列中有多少元素， 用它来确定是否可以入队或者出队。
 *
 *  对于put操作来说，
 *
 *  while（count == item.length）
 *      notFull.await()
 *
 *  count++;
 *  notEmpty.signal()
 *
 *  对于take操作来说：
 *
 *  while(count == 0 )
 *      notEmpty.await()
 *
 *  count--;
 *  notFull.signal()
 *
 *
 *  删除 remove(Object obj)：
 *
 *  怎么做？注意算法
 *
 *  when count > 0 才可以删除哦
 *
 *  遍历 takeIndex 到 putIndex 在队列中的元素, 找到元素.equals(obj)，这里说是指。 从takeIndex遍历 到等于 putIndex下标 结束
 *
 *  removeAt(int index)
 *
 *  当index在队列的头部；就是 if(index == takeIndex) 直接就可以删除元素了。
 *
 *  当index在队列的中部；你需要移动队列后面的元素来覆盖当前位置的了。
 *
 *  i = index,
 *  while(true)循环
 *  1、 next = i + 1 ; if( next == item.length ) next = 0;
 *  2、if (next != putIndex ) item[i] = item[next]; i = next;
 *  3、if（next == putIndex ） item[i] = null, count--; putIndex = i; break;
 *  4、notFull.signal();
 *
 *
 *
 */


public class ArrayBlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> arrayBlockingQueue =
                new ArrayBlockingQueue<>(20);


        arrayBlockingQueue.put(123);
        arrayBlockingQueue.add(12);

        arrayBlockingQueue.take();

        arrayBlockingQueue.remove(4);

    }


}
