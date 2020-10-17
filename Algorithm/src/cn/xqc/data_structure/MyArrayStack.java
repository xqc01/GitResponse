package cn.xqc.data_structure;

/**
 * 使用数组实现栈结构,数组默认长度为10
 */
public class MyArrayStack {
    public int[] arr;
    public int size;
    public int stackTop;

    public MyArrayStack() {
        size = 10;
        arr = new int[10];
        stackTop = -1;
    }

    public MyArrayStack(int size) {
        this.size = size;
        arr = new int[size];
        stackTop = -1;
    }

    public void push(int value) {
        if (stackTop == -1) {
            stackTop++;
            arr[stackTop] = value;
        } else if (stackTop >= 0 && stackTop < this.size - 1) {
            stackTop++;
            arr[stackTop] = value;
        } else
            throw new RuntimeException("栈已经满了");
    }

    public int pop() {
        int result;
        if (stackTop < 0) {
            throw new RuntimeException("栈已经空了");
        } else {
            result = arr[stackTop];
            stackTop--;
        }
        return result;
    }

    public void print() {
        for (int i = 0; i <= stackTop; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
