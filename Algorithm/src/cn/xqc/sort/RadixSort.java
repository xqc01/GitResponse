package cn.xqc.sort;

/**
 * 基数排序：基于关键字的排序，可用于字符串排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {236, 784, 125, 876, 345, 217, 954, 126, 378, 137, 986, 743, 246};
        RadixSort radixSort = new RadixSort();
//        System.out.println(radixSort.getTimes(arr));
        radixSort.radixSort(arr);
        Tools.print(arr);
    }

    //低位排序
    public void radixSort(int[] arr) {
        int times = this.getTimes(arr);
        int[] result = new int[arr.length];
        //int[] count = new int[10];

        //分别对每个数的个位，十位，百位进行计数排序
        for (int i = 0; i < times; i++) {
            int[] count = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j];
                int temp_i = i;
                while (temp_i-- > 0)
                    temp = temp / 10;
                int index = temp % 10;
                System.out.println(index);
                count[index]++;
                Tools.print(count);
            }
            Tools.print(count);
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k - 1];
            }
            Tools.print(count);
            for (int l = arr.length - 1; l >= 0; l--) {
                int temp = arr[l];
                System.out.println("i = " + i);
                int temp_i = i;
                while (temp_i-- > 0)
                    temp = temp / 10;
                int countIndex = temp % 10;
                int resultIndex = --count[countIndex];
                System.out.println("temp = " + temp + " countIndex = " + countIndex+" resultIndex = "+resultIndex);
                result[resultIndex] = arr[l];
            }
            System.arraycopy(result, 0, arr, 0, arr.length);
            Tools.print(result);
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    //找到数组的最大值
    public int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    //得到数组循环次数
    public int getTimes(int[] arr) {
        int times = 0;
        int max = this.findMax(arr);
        while (max > 0) {
            max = max / 10;
            times++;
        }
        return times;
    }
}
