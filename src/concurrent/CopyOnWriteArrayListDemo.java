package concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 *  CopyOnWriteArrayList
 *
 * 1. 所有的操作都是线程安全的，因为操作都是在新拷贝数组上进行的；
 * 2. 数组的拷贝虽然有一定的成本，但往往比一般的替代方案效率高；
 * 3. 迭代过程中，不会影响到原来的数组，也不会抛出 ConcurrentModificationException
 * 异常
 *
 * 1. 线程安全的，多线程环境下可以直接使用，无需加锁；
 * 2. 通过锁 + 数组拷贝 + volatile 关键字保证了线程安全；
 * 3. 每次数组操作，都会把数组拷贝一份出来，在新数组上进行操作，操作成功之后再赋值回
 * 去
 *
 * 为甚修改数组元素的内容，需要通过拷贝数组来实现呢？ 同过直接修改元素不行吗？
 *
 * volatile 修饰的是数组，单纯修改数组元素是无法触发可见性的，也就是不能保证其它线程马上看到最新的数组内容变化，
 * 必须通过修改数组的内存地址才行，也就是说对数组赋值。
 *
 * reentrantLock 保证原子性。
 *
 * 新增：
 *
 *  比如在数组末尾添加一个元素：
 *      上锁，lock = lock.lock()
 *      拷贝一个新的数组：Object[] newElements = Arrays.copyOf(elements, len + 1);
 *      在新数组末尾添加上一个新的元素。  newElements[len] = e;
 *      将新数组设为当前数组：setArray(newElements);
 *      解锁。
 *
 *
 * get() 没加锁的，可以多线程读的。
 *
 *
 *1.5 为什么 CopyOnWriteArrayList 迭代过程中，数组结构变动，不会抛出
 * ConcurrentModificationException 了
 * 答：主要是因为 CopyOnWriteArrayList 每次操作时，都会产生新的数组，而迭代时，持有的
 * 仍然是老数组的引用，所以我们说的数组结构变动，是用新数组替换了老数组，老数组的结构并
 * 没有发生变化，所以不会抛出异常了
 *
 */

public class CopyOnWriteArrayListDemo {


    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList =
                new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add(null);
//        copyOnWriteArrayList.remove(0);
        copyOnWriteArrayList.add(10);

        copyOnWriteArrayList.set(1,23);

        copyOnWriteArrayList.get(0);



        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();

        System.out.println(copyOnWriteArrayList.size());

        while (iterator.hasNext()) {

            System.out.println(iterator.next());

        }
    }

}
