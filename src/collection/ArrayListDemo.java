package collection;


import java.util.ArrayList;
import java.util.Iterator;


/**
 *  ArrayList 源码解析
 *
 *
 *  add(E e);
 *  1、先判断容量大小，数组还能否放得下，不行的，旷容为原来的1.5倍、 （增加原来的一般）
 *  2、在赋值
 *
 *
 *  扩容：
 *   Arrays.copyOf(elementData, newCapacity);
 *
 *   ，这行代码描述的本质是数组之间的拷贝，扩容是会先新建一个符合我们预期容量的新数组，
 *   然后把老数组的数据拷贝过去，我们通过 System.arraycopy 方法进行拷贝，此方法是 native 的方法
 *
 * System.arraycopy(original, 0, copy, 0,
 *                          Math.min(original.length, newLength));
 *
 *
 *  删除元素： 通过下标删除、通过对象值是否相同删除
 *
 *  remove(index)、remove(Object)。 remove多出一步 查找第一个相同对象的下标
 *
 *  数组拷贝，index的元素被覆盖。
 *  System.arraycopy(elementData, index+1, elementData, index,
 *                              numMoved);
 *  elementData[--size] = null; // clear to let GC do its work
 *
 *
 * 迭代器：
 *
 * list.iterator()  返回一个迭代器对象。
 * 简单说是遍历集合。
 * iterator.hashNext()
 * iterator.next() 获取当前位置的元素，并且返回下一个位置的元素。
 *
 * 在遍历过程中，不能通过list的方法添加或删除元素。 只能通过iterator.remove的方法删除当前元素。
 *
 * 判断 expectedModCount 是否和创建iterator前的一样。
 * cursor 小于数组的长度。
 *
 *
 *
 */


public class ArrayListDemo {


    public static void main(String[] args) {

        ArrayList list = new ArrayList();


        System.out.println(list.getClass());


        list.add(1);


        list.add(2);

        list.remove(new Integer(1));
        list.remove(0);


        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
