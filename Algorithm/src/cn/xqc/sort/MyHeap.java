package cn.xqc.sort;

/**
 * 手写堆结构（大根堆）：将数组看作一个堆结构，大根堆的父节点大于子节点
 */
public class MyHeap {

    public MyHeap() {
    }

    //向堆中插入数据 index: 要插入数的下标
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Tools.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //堆化  i：起始位置   length：堆化的长度
    public void heapify(int[] arr, int i, int length) {
        //判断起始位置及其左孩子存在
        if (i > length)
            return;
        //记录最大值下标
        while ((i * 2) + 1 < length) {
            int largest = (i * 2) + 2 < length && arr[(i * 2) + 1] < arr[(i * 2) + 2] ? (i * 2) + 2 : (i * 2) + 1;
            largest = arr[largest] > arr[i] ? largest : i;

            if (largest == i)
                return;
            Tools.swap(arr, i, largest);
            i = largest;
        }
    }

    //堆排序
    public void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int j = arr.length; j > 0; j--) {
            Tools.swap(arr, 0, j - 1);
            heapify(arr, 0, j - 1);
        }
    }

    //堆排序改进
    public void heapSort2(int[] arr) {
        //首先从后向前heapify 同样可以构成大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int j = arr.length; j > 0; j--) {
            Tools.swap(arr, 0, j - 1);
            heapify(arr, 0, j - 1);
        }
    }
}
