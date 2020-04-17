package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**

 * ConcurrentHashMap解析
 *
 * put：加锁了。两种类型的锁方式， 自旋 + cas;  synchronized 锁住链表或者红黑树的，
 *
 * 1，判断是否初始化了table
 * 2, 根据key的hash & 数组长度 ；找到数组的下标
 * 3，判断当前数组下标位置是否为null, 如果是就 cas 设置node节点，直到不空。
 * 4. 不为null, 获得当前下标对象，尝试获取这个对象锁。synchronized获取这个对象锁。
 *
 * 5，判断当前对象是链表还是红黑树
 *
 * 6. 添加方式和hash后面的相同了。
 *
 *
 * get: 没加任何锁。
 *
 * 数组是volatile修饰的
 * node
 * treebin  都是volatile修饰的。
 *
 */



public class ConcurrentHashMapDemo {


    public static void main(String[] args) {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("ljs","1s");

        concurrentHashMap.get("lj");
        System.out.println(concurrentHashMap.get(null));

        concurrentHashMap.remove(1);

        concurrentHashMap.remove(1);




    }

}
