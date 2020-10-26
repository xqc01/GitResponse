package cn.xqc.sort;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 5, 8, 2, 3, 4, 9};
//        MergeSort2 mergeSort2 = new MergeSort2();
//        mergeSort2.merge(arr,0,3,6);
//        mergeSort2.sort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        int a = (int) (Math.random() * 1000000);
//        int b = (int) (Math.random() * 1000000);
//        int a1 = a/2;
//        int a2 = a>>1;
//        System.out.println(a1 + " " + a2);
//        int result1 = (a + b) / 2;
//        int result2 = a + ((b - a) >> 1);
//        System.out.println(result1+" "+result2);
//        QuickSort2 quickSort2 = new QuickSort2();
//        quickSort2.sort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(quickSort2.hollandFlag(arr)));
//        System.out.println(Arrays.toString(arr));
//        MergeSort2 mergeSort2 = new MergeSort2();
//        mergeSort2.mergeSort(arr);
//        int i = mergeSort2.merge2(arr, 0, 3, 7);
//        int i = mergeSort2.process(arr, 0, 7);
//        Tools.print(arr);
//        System.out.println(i);
//        MyHeap myHeap = new MyHeap();
//        int[] arr = new int[]{9, 7, 6, 4, 5, 10, 18, 8};
//        myHeap.heapInsert(arr, 5);
//        Tools.print(arr);
//        myHeap.heapInsert(arr, 6);
//        Tools.print(arr);
//        myHeap.heapInsert(arr, 7);
//        Tools.print(arr);
//        MyHeap myHeap = new MyHeap();
//        int[] arr = new int[]{3, 5, 7, 9, 1, 2, 6, 4, 8};
//        myHeap.heapSort2(arr);
//        Tools.print(arr);
        int[] arr = {1, 2, 5, 8, 3, 6, 9, 4, 7};
        ImproveHeap improveHeap = new ImproveHeap((node1, node2) -> node1.value - node2.value);
//        improveHeap.sort(arr, 4);
//        Tools.print(arr);
        for (int i = 0; i < arr.length; i++) {
            improveHeap.add(arr[i]);
        }

        improveHeap.resign(3,2);

        Tools.print(improveHeap.list);
        //遍历map集合
        Set<Map.Entry<MyHeapNode, Integer>> entries = improveHeap.hashMap.entrySet();
        for (Map.Entry<MyHeapNode,Integer> entry : entries) {
            MyHeapNode key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key.value+" "+value);
        }
    }
}
