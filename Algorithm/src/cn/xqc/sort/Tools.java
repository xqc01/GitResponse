package cn.xqc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 工具类
 */
public class Tools {
    /**
     * 随机生成长度为10000的数组
     */
    static int[] randomlyGeneratedArray() {
        int[] arr = new int[10000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    //size:随机生成长度为size的数组
    static int[] randomlyGeneratedArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * 交换数组中的两个数
     *
     * @param arr    数组
     * @param index1 数组下标
     * @param index2
     */
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //交换ArrayList中的两个元素
    static <T> void swapList(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print(ArrayList<MyHeapNode> list) {
        for (MyHeapNode myHeapNode : list) {
            System.out.print(myHeapNode.value + " ");
        }
        System.out.println();
    }

    /**
     * 验证数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static boolean compareArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        boolean isEqual = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                isEqual = false;
        }
        return isEqual;
    }
}
