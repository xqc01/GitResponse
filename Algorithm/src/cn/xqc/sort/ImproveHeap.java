package cn.xqc.sort;

import java.util.*;

/**
 * 对堆的改进
 * 完成功能：修改堆内的存储对象的元素，之后仍然能够保持堆结构
 */
public class ImproveHeap {
    //优先级队列，系统类中自带的堆结构
    public PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public ImproveHeap() {
    }

    /**
     * 给定一个数组，数组从小到大排序
     * 该数组是个基本有序的数组，数组排好序后，每个元素移动位置不超过给定值K
     * 使用排序算法，时间复杂度O(nlogK)
     *
     * @param arr
     */
    public void sort(int[] arr, int K) {
        for (int i = 0; i < K; i++) {
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        for (int i = K; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
            arr[index++] = priorityQueue.poll();
        }
        for (; index < arr.length; index++) {
            arr[index] = priorityQueue.poll();
        }
    }

    /**
     * 以下内容是对堆的改进
     */
    public ArrayList<MyHeapNode> list;//堆内部封装了一个动态数组
    public HashMap<MyHeapNode, Integer> hashMap;//堆中每个节点对应的下标
    public Comparator<MyHeapNode> comparator;//比较器，规定容器中元素的比较规则
    public int size;//堆的大小

    public ImproveHeap(Comparator<MyHeapNode> comparator) {
        this.comparator = comparator;
        list = new ArrayList<>();
        hashMap = new HashMap<>();
        size = 0;
    }

    //对外接口，给堆中添加元素
    public void add(int i) {
        MyHeapNode myHeapNode = new MyHeapNode(i);
        list.add(myHeapNode);
        heapInsert(size);
    }

    //给堆中添加元素 index:添加元素的下标
    public void heapInsert(int index) {
        hashMap.put(list.get(index), size);
        size++;
        while (list.get(index).value > list.get((index - 1) / 2).value) {
            Tools.swapList(list, index, (index - 1) / 2);
            hashMap.put(list.get(index), index);
            index = (index - 1) / 2;
            hashMap.put(list.get(index), index);
        }
    }

    //从起始下标开始，向下堆化
    public void heapify(int begin, int length) {
        if (begin >= size)
            return;
        while (begin * 2 + 1 < size) {
            int largest = begin * 2 + 1;
            if (begin * 2 + 2 < size && list.get(begin * 2 + 1).value < list.get(begin * 2 + 2).value) {
                largest = begin * 2 + 2;
            }
            largest = list.get(largest).value > list.get(begin).value ? largest : begin;
            if (largest == begin)
                return;
            Tools.swapList(list, largest, begin);
            hashMap.put(list.get(largest), largest);
            hashMap.put(list.get(begin), begin);
            begin = largest;
        }
    }

    //堆内容进行修改  node:修改的堆中节点的下标  i:要修改的值
    public void resign(int index, int i) {
        list.get(index).value = i;
        heapInsert(index);
        heapify(index, list.size());
    }
}

class MyHeapNode {
    public int value;

    public MyHeapNode(int value) {
        this.value = value;
    }

    public MyHeapNode() {
    }
}