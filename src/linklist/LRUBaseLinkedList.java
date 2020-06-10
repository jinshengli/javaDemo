package linklist;


/**
 *  链表头节点
 *
 *  长度。
 *
 *  容量。
 *
 *
 *  淘汰最近最少使用。
 *
 *  添加一个元素：
 *      1） 链表容量没满，在链表头部添加元素
 *
 *      2） 链表满了，链表末尾删除元素，
 *
 *          如果这个元素出现在链表，删除，并且添加到链表头
 *          如果没有出现，直接删除队尾元素，并且添加该元素到链表头。
 *
 *
 * @param <T>
 */

public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private SNode headNode; // 哨兵头，链表头。

    private Integer length;

    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }


    /**
     *  找到节点的前一个节点。
     */

    public SNode getPreNode(T element){

        SNode sNode = headNode;

        while ( sNode.getNext() != null ){
            if ( element.equals(sNode.getNext().getElement()) ){
                return sNode;
            }
            sNode = sNode.getNext();
        }

        return null;
    }


    /**
     *  删除一个尾部元素
     */
    public void deleteLastNode(){

        SNode sNode = headNode;

        /**
         *  空链表，直接返回
         */
        if ( sNode.getNext() == null ){
            sNode = null;
        }

//        /**
//         *  只有一个链表，删除。
//         */
//        if ( sNode.getNext().getNext() == null ){
//            sNode.getNext().setNext(null);
//        }

        /**
         *  定位到倒数第二个节点。
         */
        while (sNode.getNext().getNext() != null){
            sNode = sNode.getNext();
        }

        SNode next = sNode.getNext();
        sNode.setNext(null);
        next = null;
        length--;

    }



}
