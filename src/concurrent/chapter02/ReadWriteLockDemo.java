package concurrent.chapter02;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *  读写锁
 *
 *  1. 允许多个线程同时读共享变量
 *  2. 只允许一个线程写共享变量
 *  3. 如果一个写线程正在执行，此时禁止读线程
 *
 *
 * 使用场景： 读多写少的场景
 *
 */

public class ReadWriteLockDemo {


}


/**
 *      利用读写锁+ hashMap 模拟设计一个缓存池。  数据是部分加载的，
 * @param <K>
 * @param <V>
 */

class Chache<K, V>{

    final Map<K, V> map = new HashMap<>();
    final ReadWriteLock wrLock = new ReentrantReadWriteLock();

    final Lock r = wrLock.readLock();
    final Lock w = wrLock.writeLock();

    V get(K key){

        r.lock();

        try {
            V v = map.get(key);
        }finally {
            r.unlock();
        }


        V v = map.get(key);

        if (v != null ){
            return v;
        }

        // 缓存中没有查询的数据库。需要查询数据库，更新到缓存中
        // 这里需要写锁。
        w.lock();
        try {
            v = map.get(key); // 查询一次缓存，意思是 在你获得写锁前，有其它线程已经修改过这个变量了。
            if ( v == null ){    // 注意这里判断缓存中有没有数据了。 防止没必要的查询。
                // 查询 数据库。
//                    v =
                map.put(key, v);
            }
        }finally {
            w.unlock();
        }

        return v;
    }

    V put(K key, V data){

        w.lock();
        try {
            return map.put(key, data);
        } finally {
            w.unlock();
        }

    }



}