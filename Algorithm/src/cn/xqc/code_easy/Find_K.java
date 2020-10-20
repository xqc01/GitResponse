package cn.xqc.code_easy;

/**
 * 寻找数组中第K大的数
 */
public class Find_K {
    /**
     * 寻找第K大
     *
     * @param a 数组
     * @param n 数组长度
     * @param K 要找的第K大个数
     * @return 返回数组中的数
     */
    public int findKth(int[] a, int n, int K) {
        if (n <= 0)
            return 0;
        for (int i = 0; i < K; i++) {
            this.heapSort(a, n - i);
        }
        int result = a[n - K];
        return result;
    }

    //进行一次堆排序
    //length:数组中进行堆排序的数的个数
    public void heapSort(int[] arr, int length) {
        if (length <= 1)
            return;
        int last = (length - 2) / 2;
        for (int i = last; i >= 0; i--) {
            if (length > (2 * i + 1) && arr[i] < arr[2 * i + 1])
                this.swap(arr, i, i * 2 + 1);
            if (length > (2 * i + 2) && arr[i] < arr[2 * i + 2])
                this.swap(arr, i, i * 2 + 2);
        }
        this.swap(arr, 0, length - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
