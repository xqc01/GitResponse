package cn.xqc.sort;

/**
 * 归并排序：将数组先拆分，直到只有一个数，此时默认有序，再将有序的数组合并
 * 1.使用循环完成
 * 2.求数组小和：将数组的所有小于右边数的左边数相加，例如：
 * 数组{1,4,7,2,6}   小和是 1+1+4+1+1+4+2
 */
public class MergeSort2 {
    public void sort(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int leftPos = left;
        int rightPos = mid + 1;
        int[] result = new int[right - left + 1];
        int resultIndex = 0;
        while (leftPos <= mid && rightPos <= right) {
            //System.out.println("resultIndex=" + resultIndex + " leftPos=" + leftPos + " rightPos=" + rightPos);
            result[resultIndex++] = arr[leftPos] <= arr[rightPos] ? arr[leftPos++] : arr[rightPos++];
        }
        while (leftPos <= mid) {
            result[resultIndex++] = arr[leftPos++];
        }
        while (rightPos <= right) {
            result[resultIndex++] = arr[rightPos++];
        }
        for (int i = 0; i < result.length; i++) {
            arr[i + left] = result[i];
        }
    }

    //使用循环完成
    public void mergeSort(int[] arr) {
        //数组进行合并的大小
        int mergeSize = 2;
        while (mergeSize / 2 <= arr.length) {
            //遍历数组
            int i = 0;
            while (i < arr.length) {
                int right = Math.min(arr.length - 1, i + mergeSize - 1);
                //System.out.println(i+" "+(i+mergeSize/2-1)+" "+right);
                if (right > i)
                    merge(arr, i, i + mergeSize / 2 - 1, right);
                i += mergeSize;
            }
            //防止int类型变量移除
            if (mergeSize > arr.length) {
                System.out.println("ok");
                break;
            }
            mergeSize <<= 1;
            //Tools.print(arr);

        }
    }

    //求数组小和
    public int makeLittlePeace(int[] arr) {
        int result = 0;
        return result;
    }

    public int process(int[] arr, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid)
                + process(arr, mid + 1, right)
                + merge2(arr, left, mid, right);
    }

    public int merge2(int[] arr, int left, int mid, int right) {
        int result = 0;
        int leftPos = left;
        int rightPos = mid + 1;
        int i = 0;
        int[] arr_i = new int[right - left + 1];
        while (leftPos <= mid && rightPos <= right) {
            if (arr[leftPos] < arr[rightPos]) {
                arr_i[i++] = arr[leftPos];
                result += (right - rightPos + 1) * arr[leftPos++];
            } else {
                arr_i[i++] = arr[rightPos++];
            }
        }
        while (leftPos <= mid) {
            arr_i[i++] = arr[leftPos++];
        }
        while (rightPos <= right) {
            arr_i[i++] = arr[rightPos++];
        }
        for (int j = 0; j < arr_i.length; j++) {
            arr[j + left] = arr_i[j];
        }
        return result;
    }
}
