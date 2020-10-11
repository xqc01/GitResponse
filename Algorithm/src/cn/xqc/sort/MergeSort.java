package cn.xqc.sort;

import java.util.Arrays;

/**
 * 归并排序：运用递归，将数组分成有序的子数组，再进行合并为有序的数组
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = Tools.randomlyGeneratedArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
//        Tools.print(arr1);
//        Tools.print(arr2);
        //Tools.print(new MergeSort().merge(arr, 5, 6, 6));
        new MergeSort().sort(arr1);
        Arrays.sort(arr2);
        Tools.print(arr1);
        Tools.print(arr2);

        boolean isEqual = true;
        for (int i =0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                isEqual = false;
            }
        }
        System.out.println(isEqual);
    }

    public void sort(int[] arr) {
        int leftPos = 0;
        int midPos = arr.length / 2;
        int rightPos = arr.length - 1;
        this.split(arr, leftPos, midPos, rightPos);
    }

    /**
     * 将数组不断细分
     *
     * @param arr
     * @param leftPos
     * @param midPos
     * @param rightPos
     * @return
     */
    public void split(int[] arr, int leftPos, int midPos, int rightPos) {
//        int leftPos = 0;
//        int midPos = arr.length / 2;
//        int rightPos = arr.length - 1;
        if (rightPos - leftPos == 1)
            return;
        if (midPos - leftPos != 1)
            this.split(arr, leftPos, leftPos + (midPos - leftPos) / 2, midPos);
        this.merge(arr, leftPos, leftPos + (midPos - leftPos) / 2, midPos);
        if (rightPos - midPos != 0)
            this.split(arr, midPos, midPos + (rightPos - midPos) / 2 + 1, rightPos);
        this.merge(arr, midPos, midPos + (rightPos - midPos) / 2 + 1, rightPos);

        //Tools.print(arr);
        this.merge(arr, leftPos, midPos, rightPos);
        //Tools.print(arr);
    }

    /**
     * 将两个子数组合并为一个数组
     *
     * @param arr      数组
     * @param leftPos  左下标
     * @param midPos   中间下标
     * @param rightPos 右下标
     * @return 合并后的数组
     */
    public int[] merge(int[] arr, int leftPos, int midPos, int rightPos) {
        int mid = midPos;
        int[] temp = new int[rightPos - leftPos + 1];//临时数组，合并后的数组
        //将数组分为排好序的两个子数组  i和j两个数组的起始位置  k指向temp数组
        int i = leftPos;
        int j = mid;
        int k = 0;

        //循环直到两个子数组结束
        while (i < mid && j <= rightPos) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
//                System.out.println("i = "+i+" k = "+k);
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
//            System.out.println("i = " + i + " j = " + j + " k = " + k);
//            Tools.print(temp);
        }

        //将子数组中剩下的数全部移到temp数组中
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightPos) {
            temp[k++] = arr[j++];
        }

        //Tools.print(temp);
        for (int l = 0; l < temp.length; l++) {
            arr[leftPos + l] = temp[l];
        }
        return arr;
    }
}