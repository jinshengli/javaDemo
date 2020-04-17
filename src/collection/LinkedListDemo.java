package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


/**
 *  LinkedList 源码解析:
 *
 *  底层是双向链表结构。任意节点都能找到它的前后节点。
 *
 *  1. 添加元素，可以从头部添加元素、尾部添加元素，默认尾部添加元素。
 *   linkLast(E e)。
 *
 *  2. 删除，头尾，中间元素删除。 默认头部删除。
 *
 *
 *
 *  3. 查询
 *  get(index)  --- >node(int index)
 *
 *  判断index在链表的前半部分还是后半部分
 *  前：利用next指针从 前->后
 *  后：利用prev 从 后->前
 *
 *
 *
 *
 */

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("wowow");
        linkedList.addFirst("ww");

        linkedList.removeFirst();

        System.out.println(linkedList.remove("lll"));

        System.out.println(linkedList.get(3));

        linkedList.poll();
        linkedList.peek();
        linkedList.offer("111");

        linkedList.offer("222");
        linkedList.poll();

        linkedList.remove();


        Iterator<?> iterator = linkedList.iterator();

        ListIterator<?> ListIterator = linkedList.listIterator();


        System.out.println(linkedList);


    }
}
