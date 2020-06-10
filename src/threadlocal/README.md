#### ThreadLocal 两个使用方式

1：让某个需要用到的对象在线程间间隔；每个线程都有自己的独立的对象。

多线程公用一个 线程不安全的工具类


2: 避免传递参数的麻烦

在任何方法中都可以轻松获取到该对象

#### ThreadLocal和Thread的关系

1) 一个Thread对应一个ThreadLocalMap
2) 一个ThreadLocalMap对应多个ThreadLocal



#### ThreadLocalMap类

ThreadLocalMap类是*每个线程Thread类里面的变量*，
里面最重要的是一个键值对数组**Entry[] table**, 可认为是一个map;

###### 键：一个ThreadLocal对象
###### 值：实际需要的成员变量，比如user或者其他对象

    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }

#### ThreadLocal的重要方法

###### initialValue()

1. 该方法会放回当前线程对应的“初始值”，
这是一个延迟加载的方法，只有调用get的时候，才会触发。
2. 此线程第一个使用get方法访问变量时，将调用此方法，除非线程
先调用了set方法，这种情况下，不会为线程调用本initialValue方法
3. 通常，每个线程最多调用一次次方法，但是如果已经调用了remove()后，
再调用get(),则可以再次调用此方法。

##### T initialValue(): 初始化

##### void set(T t):  为这个线程设置一个新值

##### T get(): 得到这个线程对应的Value。如果是首次调用get(),则会调用initialize来
得到这个值

##### void remove(): 删除这个线程的值


#### 避免内存泄漏（阿里规约）

调用remove方法，就会删除对应的Entry对象，可以避免内存泄漏，所有使用完
ThreadLocal之后，应该调用remove方法。

#### 注意点

空指针异常，get获取的是对象，如果用基本类型接收，会经过拆箱过程，如果是
null 会出现空指针异常。