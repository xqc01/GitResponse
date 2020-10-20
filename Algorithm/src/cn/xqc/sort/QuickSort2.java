package cn.xqc.sort;

/**
 * 随机快排  荷兰三色国旗
 */
public class QuickSort2 {
    public void sort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = process(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    //取一个随机标记位放到数组最后位置，将数组分为小于区和大于区，返回标记位的下标
    public int process(int[] arr, int left, int right) {
        //取随机数
//        int random = left + (int) (Math.random() * (right - left));
//        Tools.swap(arr, random, right);
        int lessIndex = left - 1;
        int moreIndex = right;
        int i = left;
        while (i < moreIndex) {
            if (arr[i] <= arr[right]) {
                Tools.swap(arr, i++, ++lessIndex);
            } else {
                Tools.swap(arr, i, --moreIndex);
            }
        }
        Tools.swap(arr, right, moreIndex);
        return moreIndex;
    }

    //荷兰三色国旗问题：将数组分为三部分，小于区，等于区，大于区  返回等于区的左右下标
    public int[] hollandFlag(int[] arr) {
        int mark = arr[arr.length - 1];
        int lessIndex = -1;
        int moreIndex = arr.length - 1;
        int i = 0;
        while (i < moreIndex) {
            if (arr[i] < mark) {
                Tools.swap(arr, i, ++lessIndex);
                i++;
            } else if (arr[i] == mark) {
                i++;
            } else {
                Tools.swap(arr, i, --moreIndex);
            }
        }
        Tools.swap(arr, arr.length - 1, moreIndex);
        return new int[]{++lessIndex, moreIndex};
    }
}