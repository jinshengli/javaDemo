package concurrent.chapter02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsSyncDemo {

    public static void main(String[] args) {

        List list = Collections.synchronizedList(new ArrayList<>());

        Map map = Collections.synchronizedMap(new HashMap<>());

        Set set = Collections.synchronizedSet(new HashSet<>());

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();




    }


}
