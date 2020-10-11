package cn.xqc.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr;
        arr = Tools.randomlyGeneratedArray();

        new SelectionSort().sort(arr);
        Tools.print(arr);
    }

    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;//最小值的下标

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            Tools.swap(arr, i, minIndex);
        }
    }
}
