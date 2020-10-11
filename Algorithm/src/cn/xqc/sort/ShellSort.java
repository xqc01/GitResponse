package cn.xqc.sort;

import javax.tools.Tool;
import java.util.Arrays;
import java.util.function.ToLongBiFunction;

/**
 * 希尔排序：有间隔的分组插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr1 = Tools.randomlyGeneratedArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1,0,arr2,0,arr2.length);
        new ShellSort().sort(arr1);
        Arrays.sort(arr2);
        Tools.print(arr1);
        Tools.print(arr2);
        boolean isEquals = Tools.compareArray(arr1,arr2);
        System.out.println(isEquals);
    }

    public void sort(int[] arr) {
        //h:初始间隔大小
        for (int h = arr.length / 3; h > 0; h = h / 2) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j+1] < arr[j]) {
                        Tools.swap(arr, j+1, j);
                    } else break;
                }
                //Tools.print(arr);
            }

//            Tools.print(arr);
        }
    }
}
