package cn.xqc.sort;

import java.util.Arrays;

/**
 * 计数排序：适用于量大范围小的数据
 * 算法思想：数据的范围对应桶数组的下标 桶数组初始值0 遍历原数组 桶数组中的对应值+1
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {2,5,7,1,2,4,5,9,7,2,0,8,2,4,7,0,8,6,4,1,3,4,6,0,8,1,5};
        int[] result = new CountSort().sort(arr);
        System.out.println(Arrays.toString(result));
    }

    public int[] sort(int[] arr){
        //计数数组，统计数据出现的次数，数组长度位数据范围
        int[] count = new int[10];
        //返回数组，将计数数组中的个数，还原到真实数组中
        int[] result = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            int temp = arr[i];
            count[temp]++;
        }
        //System.out.println(Arrays.toString(count));

        /**
         * 将count数组变为累加数组
         * 例如：原count数组{2，3，1}  累加后的count数组{2，5，6}
         * 此时计数数组中的每个数值记录了其对应数据在排好序的数组中的下标
         * 而后倒着遍历原数组，按照累加数组的记录，挨个插入result数组，就可以使排序稳定
         */
        for (int j = 1;j<count.length;j++){
            count[j] = count[j]+count[j-1];
        }
        //System.out.println(Arrays.toString(count));
        for (int k = arr.length - 1; k>=0;k--){
            int temp = arr[k];
            int index = count[temp] -1;
            result[index] = arr[k];
            count[temp]--;
        }
        return result;
    }
}
