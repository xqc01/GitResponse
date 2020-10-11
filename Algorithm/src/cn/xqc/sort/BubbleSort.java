package cn.xqc.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {23, 45, 15, 6, 98, 43, 2};
        new BubbleSort().sort(arr);
    }

    public void sort(int[] arr) {
        Tools.print(arr);
        int sum;//标记位 记录该次循环做了几次交换操作
        while (true) {
            sum = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sum++;
                    Tools.swap(arr, i, i + 1);
                }
            }
            Tools.print(arr);
            if (sum == 0) {
                break;
            }
        }
    }
}
