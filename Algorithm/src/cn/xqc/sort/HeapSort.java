package cn.xqc.sort;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = Tools.randomlyGeneratedArray();
        HeapSort heapSort = new HeapSort();
        heapSort.heapHeap(arr);
        Tools.print(arr);
    }

    //封装
    public void heapHeap(int[] arr){
        int length = arr.length;
        this.recursion(arr,length);
    }

    //进行递归，直到 sort() 中的 length 为1
    public void recursion(int[] arr, int length) {
        if (length <= 1) return;
        this.sort(arr, length);
        this.recursion(arr, length - 1);
    }

    //构造大根堆，然后将数组第一位的数，放到 length-1 位
    public void sort(int[] arr, int length) {
        //从最后一个叶子节点的父节点开始遍历
        int lastIndex = (length - 1) / 2;
        for (int i = lastIndex; i >= 0; i--) {
            //在数组中，父节点的左右子节点为 2n+1 和 2n+2
            //判断小于length，防止数组越界
            if (i * 2 + 1 < length && arr[i * 2 + 1] > arr[i]) {
                Tools.swap(arr, i, i * 2 + 1);
            }
            if (i * 2 + 2 < length && arr[i * 2 + 2] > arr[i]) {
                Tools.swap(arr, i, i * 2 + 2);
            }
//            Tools.print(arr);
        }
        Tools.swap(arr, 0, length - 1);
//        Tools.print(arr);
    }
}
