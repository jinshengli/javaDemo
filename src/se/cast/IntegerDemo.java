package se.cast;

/**
 * create by ljs on 2020/5/6 9:16
 *
 *  ①比较的是值
 * 一、基本数据类型与引用数据类型进行比较时，引用数据类型会进行拆箱，然后与基本数据类型进行值的比较
 * 举例：
 * int i = 12;
 * Integer j = new Integer(12);
 * i == j 返回的是true
 * 二、引用数据类型与基本数据类型进行比较（equals方法），基本数据类型会进行自动装箱，与引用数据类型进行比较，Object中的equals方法比较的是地址，但是Integer类已经重写了equals方法，只要两个对象的值相同，则可视为同一对象，具体看API文档，所以这归根到底也是值的比较！
 * 举例：
 * int i = 12;
 * Integer j = new Integer(12);
 * j.equals(i) 返回的是true
 * ②比较的是地址
 * 一、如果引用数据类型是这样 Integer i = 12;直接从常量池取对象，这是如果数值是在-128与127之间，则视为同一对象，否则视为不同对象
 * 举例：
 * Integer i = 12; Integer j = 12; i == j 返回的是true
 * Integer i = 128; Integer j = 128; i == j 返回的是false
 * 二、如果引用数据类型是直接new的话，不管值是否相同，这时两个对象都是不相同的，因为都会各自在堆内存中开辟一块空间
 * 举例：
 * Integer i =new Integer(12);
 * Integer j = new Integer(12);
 * i == j 这时返回的是false
 * 三、从常量池取对象跟new出来的对象也是不同的
 * 举例：
 * Integer i = 12;
 * Integer j = new Integer(12)
 * i == j 这时返回的是false，因为第二个语句其实已经是new了两个对象了！！！
 *
 *
 *
 */
public class IntegerDemo {


    public static void main(String[] args) {

        Integer integer = new Integer(100);

        Integer in = 100;
        Integer oq = 100;

        System.out.println(in == oq); // true

        System.out.println(in.equals(oq)); // true

        int o = 100;

        System.out.println(integer == o); // true

        System.out.println(in == integer); // false

        System.out.println(in == o);  // true

        int i = Integer.parseInt("100");

        System.out.println(i == integer);  // true

        System.out.println(integer.equals(i));  // true

        // 上面都是 -128 - 127 的值
        System.out.println("==================");

        int p = 1000;
        Integer pp = new Integer(1000);

        Integer d = 1000;

        Integer b = 10000;


        System.out.println( p == pp );  // true

        System.out.println(d == b ); // false


    }



}
