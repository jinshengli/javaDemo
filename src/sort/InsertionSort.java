package sort;

/**
 *  插入排序。
 *
 *  动态地往有序的数组中添加元素, 找到正确插入元素的位置。 需要移动数据。
 *
 *  将数组划分为两个部分，一个是有序的，另外是未排序的。
 *
 *  覆盖最后一个元素。
 *
 *
 */

public class InsertionSort {


    public void sort( int arr[] ){

        int tmp, j;

        for ( int i = 1; i < arr.length; ++i ){

            tmp = arr[i];

            for ( j = i-1; j >=0; -- j ){
                if ( arr[j] > tmp ){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }

    }

    public static void main(String[] args) {

        int arr[] = {1,20,32,1,3,4,5};
        //int arr[] = {2,3,5,6,7,8,9};
        new InsertionSort().sort(arr);

        for (int a:arr){
            System.out.print( a + "  ");
        }

    }



}
