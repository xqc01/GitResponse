package cn.xqc.sort;

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
}
