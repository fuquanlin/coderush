package cn.fql.coderush.algorithm;

import java.util.Arrays;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class QuickSort {


    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            sort(array, low, middle - 1);
            sort(array, middle + 1, high);
        }
    }

    public static int getMiddle(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];

        }
        array[low] = tmp;
        return low;


    }

    public static void main(String[] args) {
        int array[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        sort(array, 0, array.length-1);
        Arrays.stream(array).forEach(a -> System.out.printf(a + " "));
    }
}
