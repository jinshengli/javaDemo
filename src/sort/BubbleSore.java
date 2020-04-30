package sort;

/**
 *   冒泡排序。
 *
 *   一次冒泡排序：从数组头开始，每次和相邻的元素比较，逆序的话交换元素，一直到数组末尾。
 *   一共进行 n-1 次冒泡排序。
 *
 *   冒泡排序的时间复杂度：
 *   最优 O(n), 最坏 O(n^2)
 *
 *   原地排序算法
 *
 *   稳定的算法，比如里面有相同的元素，它们在原来数组位置的顺序是不变的。
 *
 *
 *
 */

public class BubbleSore {

    public void sort(int []arr){

        boolean flag = false;  // false 代表有序了。
        for ( int i = 0; i < arr.length -1; ++i ){
            for ( int j = 0; j < arr.length-i-1; ++j ){
                if ( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                    System.out.println("sort");
                }
            }
            if ( flag == false ) // 不用交换，代表数组有序了。
                break;
        }

    }

    public static void main(String[] args) {

        //int arr[] = {1,20,32,1,3,4,5};
        int arr[] = {2,3,5,6,7,8,9};
        new BubbleSore().sort(arr);
        for (int a:arr){
            System.out.print( a + "  ");
        }
    }


}
