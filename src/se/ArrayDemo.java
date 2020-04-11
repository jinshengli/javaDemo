package se;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo {

    int[] a;

    int anInt[] = new int[3];

//    int []anInt1;  anInt1 = {1,2,3,4};
//
//    int[] A = new int[3]{1,2,3};

    protected int[] B = {1,23,12,4};

    public static Integer findN(int [] arr,  int n){

        for ( int i=0; i < arr.length; ++i ){
            if ( arr[i] == n )
                return i;
        }
        return -1;
    }

    /**
     *  冒泡排序
     * @param arr
     */

    public static void maopaoSort(int [] arr ){
        for ( int i=0; i < arr.length-1; ++ i ){
            for (int j = i+1; j < arr.length; ++j ){
                if ( arr[i] > arr[j] ){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }






    public static void main(String[] args) {

        int[] B = {1,23,12,4};

        maopaoSort(B);
        Integer n = findN(B, 189);
        System.out.println(n);

        for( int i=0; i < B.length; ++i )
            System.out.print(B[i] + " ");

    }


}
