package cn.fql.coderush.algorithm;

import java.util.Arrays;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class BubbleSort {


    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 2, 1, 3, 9, 7, 8, 0};
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        Arrays.stream(array).forEach(a-> System.out.printf(a+""));
    }
}
