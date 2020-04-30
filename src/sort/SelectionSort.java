package sort;


/**
 *  选择排序。 【重点是选择】
 *
 *  也是将数组划分为有序和无序。 每次从未排序的元素中选择一个最小的，然后添加到有序中的末尾。
 *
 *  注意：未排序中【最小的元素】 和 未排序中【第一个元素】交换。
 *
 *  记录最小元素的下标
 *
 *
 */

public class SelectionSort {

    public void sort(int []arr){

        if ( arr.length <= 1 )
            return;
        int index;
        for (int i=0; i < arr.length; ++i ){
            index = i;
            for ( int j = i+1; j < arr.length; ++j ){
                if ( arr[j] < arr[index] ){
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {

        int arr[] = {1,20,32,1,3,4,5};
        //int arr[] = {2,3,5,6,7,8,9};
        new SelectionSort().sort(arr);
        for (int a:arr){
            System.out.print( a + "  ");
        }

    }


}
