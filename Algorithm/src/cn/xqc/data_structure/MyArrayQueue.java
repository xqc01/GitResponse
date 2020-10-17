package cn.xqc.data_structure;

/**
 * 使用数组实现队列，默认长度10
 */
public class MyArrayQueue {
    public int[] arr;
    public int size;
    public int begin;
    public int end;

    public MyArrayQueue() {
        arr = new int[10];
        size = 0;
        begin = 0;
        end = 0;
    }

    public void push(int value) {
        if (size == 0) {
            size++;
            arr[begin] = value;
        } else if (size > 0 && size <= 10) {
            size++;
            end++;
            arr[end] = value;
        } else
            throw new RuntimeException("队列已经满了");
    }

    public int pop() {
        int result;
        if (size < 1) {
            throw new RuntimeException("队列已经空了");
        } else {
            result = arr[end];
            end--;
            size--;
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            int index = (i + begin) % 10;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }
}
