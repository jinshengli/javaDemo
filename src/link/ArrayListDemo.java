package link;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {


        Collection<Integer> collection = new LinkedList<>();

        for (int i=0; i<5; ++i ){
            collection.add(i);
        }





        ArrayList arrayList = new ArrayList(collection);

        System.out.println(arrayList.contains(1));

        arrayList.clear();

//        for (int i =0; i<5; ++i ){
//           arrayList.set(i, i+1);
//        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        Iterator<Integer> iterator1 = collection.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }

    }


}
