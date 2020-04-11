package link;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer, User> hashMap = new HashMap<>();

        hashMap.put(1, new User("ljs",12));

        hashMap.put(2, new User("ljs1",12));

        hashMap.put(3, new User("123csd",12));

        Set<Integer> set = hashMap.keySet();

        Iterator<Integer> iterator2 = hashMap.keySet().iterator();

        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();

        Iterator<Map.Entry<Integer, User>> iterator = hashMap.entrySet().iterator();


        Iterator iterator1 = hashMap.entrySet().iterator();

        while (iterator1.hasNext()){

            Map.Entry<Integer, User> next = (Map.Entry<Integer, User>) iterator1.next();
            System.out.println(next.getKey()  );

            System.out.println(next.getValue());


        }


        Collection<User> values = hashMap.values();




    }


}
