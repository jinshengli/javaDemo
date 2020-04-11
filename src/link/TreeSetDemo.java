package link;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i =0 ; i < 6; ++i ){
            treeSet.add(i);
        }

        Iterator<Integer> iterator = treeSet.iterator();


        TreeSet<User> set = new TreeSet<>();

        for (int i=0; i< 7; ++ i){
            set.add(new User("user", 112-i));
        }

        set.add(new User("a",134));

//        set.add(null); 不允许又null值

        Iterator<User> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


    }


}
