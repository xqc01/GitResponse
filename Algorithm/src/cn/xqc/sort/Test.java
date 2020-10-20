package cn.xqc.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 8, 2, 3, 4, 9};
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
//        QuickSort2 quickSort2 = new QuickSort2();
//        quickSort2.sort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(quickSort2.hollandFlag(arr)));
//        System.out.println(Arrays.toString(arr));
        MergeSort2 mergeSort2 = new MergeSort2();
//        mergeSort2.mergeSort(arr);
//        int i = mergeSort2.merge2(arr, 0, 3, 7);
        int i = mergeSort2.process(arr, 0, 7);
        Tools.print(arr);
        System.out.println(i);
    }
}
