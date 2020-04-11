package link;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        TreeMap treeMap = new TreeMap(new PersonComparator());

        for (int i=0; i < 10; ++i ){
            treeMap.put(new Person(100 - i, "person" + i), i);
        }


        Iterator iterator = treeMap.entrySet().iterator();
        while ( iterator.hasNext() ){
            System.out.println(iterator.next());
        }

        Comparator comparator = treeMap.comparator();
        System.out.println(comparator);


    }

    static class PersonComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;

            int cid = p1.getId() - p2.getId();

            int result = cid == 0 ? p1.getName().compareTo(p2.getName()) : cid;

            return result;

        }
    }
}
