package se.collectiondemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestList{
    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add(1,"Learn");
        list.add(1,"Java");
        printList(list);
    }
    public static void printList(List list){

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static void concurrnetHashMapDemo(){

        ConcurrentHashMap map = new ConcurrentHashMap();

        map.put("x",12);


    }



}