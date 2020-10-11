package cn.xqc.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = Tools.randomlyGeneratedArray();
        new InsertionSort().sort(arr);
        Tools.print(arr);
    }

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j+1] < arr[j]) {
                    Tools.swap(arr, j+1, j);
                } else break;
            }
            //Tools.print(arr);
        }
    }
}
