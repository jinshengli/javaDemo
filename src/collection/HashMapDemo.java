package collection;


import java.util.*;

/**
 *  简单总结hashMap的方法的总结
 *
 *  put源码解读：
 *
 *  1、首先判断table 数组是有没有初始化，没有就初始化。
 *  2、计算hash = hash(key)值, 然后hash & (n-1) 计算当前<k,v>对存放的索引下标。
 *  3、判断当前索引位置是否为null(有没有元素)，没有就 新建 Node(k,v)节点，填到当前位置
 *  4、当前位置有元素，判断该元素的类型，TreeNode、还是Node。（红黑树还是链表）
 *  5、是红黑树就按照红黑树的方式添加进去（覆盖还是不覆盖存在key）
 *  6、是链表的话，遍历整个链表，链表中是否有相同的key存在，存在就退出遍历（后边覆盖还是不覆盖value)，
 *    如果是遍历到链表结尾，就在尾部连上新创建的节点。
 *
 *  7、 如果在链表尾部添加一个节点的话，判断链表长度是否>8, 如果大于执行 treeifyBin
 *
 *   treeifyBin 的作用是：判断是数组扩容，还是链表成红黑树。
 *
 *   当链表的长度>8, 并且数组长度<64, 进行数组扩容。
 *
 *   if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
 *      resize()
 *   else
 *      链表 --> 红黑树 【使用 HashMap 时，几乎不会碰到链表转化成红黑树的情况，毕竟概念只有千万分之
 * 一。】
 *
 */


public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap();



        hashMap.put(null, "vvv");

        hashMap.put("llsls", "sss");

        hashMap.put("wo","sss");




        Set<Map.Entry<String, String>> entries = hashMap.entrySet();

        for (Map.Entry<?,?> entry:entries){
            System.out.println(entry);
        }

        Iterator<?> iterator = hashMap.entrySet().iterator();

        System.out.println("//////////////");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("////////////////////");
        String v = "";




    }
}
