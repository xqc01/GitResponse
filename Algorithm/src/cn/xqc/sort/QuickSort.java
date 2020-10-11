package cn.xqc.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = Tools.randomlyGeneratedArray();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1,0,arr2,0,arr2.length);
        fastSort(arr1, 0, arr1.length-1);
        Arrays.sort(arr2);
        Tools.print(arr1);
        Tools.print(arr2);
    }

    public static void fastSort(int[] arr, int leftPos, int rightPos) {
        if (leftPos >= rightPos) return;
        QuickSort quickSort = new QuickSort();
        int mid = quickSort.sort(arr, leftPos, rightPos);
        //System.out.println(mid);
        fastSort(arr, leftPos, mid - 1);
        fastSort(arr, mid + 1, rightPos);
    }

    /**
     * 将数组中 小于标记位的移向标记位的左边 大于的在右边
     *
     * @param arr      原数组
     * @param leftPos  数组进行排序的最左位置
     * @param rightPos 数组进行排序的最右位置
     * @return 返回排序后标记位的位置
     */
    public int sort(int[] arr, int leftPos, int rightPos) {
        int mark = leftPos;
        int leftPointer = leftPos + 1;
        int rightPointer = rightPos;
        //在外层增加一个while（）
        while (leftPointer < rightPointer) {
            if (arr[leftPointer] >= arr[mark]) {
                while (rightPointer > leftPointer) {
                    if (arr[rightPointer] < arr[mark]) {
                        Tools.swap(arr, leftPointer, rightPointer);
                        //System.out.println("此时的leftPointer = " + leftPointer + " rightPointer = " + rightPointer);
                        break;
                    }
                    rightPointer--;
                }
            }
            //System.out.println("此时的leftPointer = "+leftPointer+" rightPointer = "+rightPointer);
            leftPointer++;
            //Tools.print(arr);
        }
        //System.out.println("交换标记位时" + leftPointer + rightPointer);

        //当数组的第一个数为最大值时，进入else语句
        if (arr[mark] <= arr[rightPointer]) {
            Tools.swap(arr, mark, rightPointer - 1);
            return rightPointer - 1;
        } else Tools.swap(arr, mark, rightPointer);
        return rightPointer;
    }
}
//    public int sort(int[] arr, int leftPos, int rightPos) {
//        System.out.println("执行了一次sort");
//        if (rightPos - leftPos <= 1)
//            return leftPos;
//        int mark = leftPos;//标记位下标
//        int j = rightPos;
//        //从左向右找到大于标记位的数
//        for (int i = leftPos + 1; i <= rightPos; i++) {
//            if (i == j) {
//                if (arr[i] > arr[mark]) {
//                    //System.out.println("此时i = j = mark = " + i + j+mark);
//                    Tools.swap(arr, mark, i - 1);
//                    mark = i - 1;
//                    //Tools.print(arr);
//                    //System.out.println(mark);
//                } else {
//                    Tools.swap(arr, mark, i);
//                }
//                System.out.println(i);
//                return i;
//            }
//            if (arr[i] >= arr[mark]) {
//                //System.out.println("i = " + i);
//                //从右向左找到小于标记位的数
//                for (j = rightPos; j >= leftPos + 1; j--) {
//                    if (i == j) {
//                        Tools.swap(arr, i - 1, mark);
//                        return i -1;
//                    }
//                    if (arr[j] < arr[mark]) {
//                        //System.out.println("j = " + j);
//                        Tools.swap(arr, i, j);
//                        break;
//                    }
//                }
//            }
//            //System.out.println("i = " + i + " j = " + j);
//            //Tools.print(arr);
//        }
////        Tools.print(arr);
////        this.sort(arr, leftPos, mark - 1);
////        this.sort(arr, mark, rightPos);
//        Tools.print(arr);
//    }
//}
