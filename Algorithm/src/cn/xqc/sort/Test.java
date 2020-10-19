package cn.xqc.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 8, 3, 4, 9,12,4,56,7};
//        MergeSort2 mergeSort2 = new MergeSort2();
//        mergeSort2.merge(arr,0,3,6);
//        mergeSort2.sort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        int a = (int) (Math.random() * 1000000);
//        int b = (int) (Math.random() * 1000000);
//        int a1 = a/2;
//        int a2 = a>>1;
//        System.out.println(a1 + " " + a2);
//        int result1 = (a + b) / 2;
//        int result2 = a + ((b - a) >> 1);
//        System.out.println(result1+" "+result2);
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
