package cn.xqc.data_structure;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        MyLinkedQueue myLinkedQueue = new MyLinkedQueue();
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        myLinkedQueue.push(node1);
//        myLinkedQueue.push(node2);
//        myLinkedQueue.push(node3);
//        myLinkedQueue.push(node4);
//        myLinkedQueue.push(node5);
//        myLinkedQueue.print();
//        myLinkedQueue.print();
//        MyArrayStack myArrayStack = new MyArrayStack(5);
//        myArrayStack.push(1);
//        myArrayStack.push(2);
//        myArrayStack.push(3);
//        myArrayStack.push(4);
//        myArrayStack.push(5);
//        myArrayStack.print();
//        MyArrayQueue myArrayQueue = new MyArrayQueue();
//        myArrayQueue.push(1);
//        myArrayQueue.push(2);
//        myArrayQueue.push(3);
//        myArrayQueue.push(4);
//        myArrayQueue.push(5);
//        myArrayQueue.print();
//        StackSimulateQueue stackSimulateQueue = new StackSimulateQueue();
//        stackSimulateQueue.push(1);
//        stackSimulateQueue.push(2);
//        stackSimulateQueue.push(3);
//        stackSimulateQueue.push(4);
//        stackSimulateQueue.push(5);
//        stackSimulateQueue.push(6);
//        System.out.println(stackSimulateQueue.pop());
//        System.out.println(stackSimulateQueue.pop());
//        System.out.println(stackSimulateQueue.pop());
//        System.out.println(stackSimulateQueue.pop());
//        System.out.println(stackSimulateQueue.pop());
//        System.out.println(stackSimulateQueue.pop());
//        QueueSimulateStack queueSimulateStack = new QueueSimulateStack();
//        queueSimulateStack.push(1);
//        queueSimulateStack.push(2);
//        queueSimulateStack.push(3);
//        System.out.println(queueSimulateStack.pop());
//        System.out.println(queueSimulateStack.pop());
//        System.out.println(queueSimulateStack.pop());
//        UseXOR useXOR = new UseXOR();
//        System.out.println(useXOR.getLastOne(8));
//        int[] arr = {1, 2, 2, 1, 3, 3, 5, 5, 5, 4, 4, 6, 5, 2, 10, 10, 11, 2, 6, 12};
//        System.out.println(useXOR.getOddNumber(arr));
//        System.out.println(Arrays.toString(useXOR.getTwoOddNumber(arr)));
//        String str = null;
//        System.out.println(str);
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("abc");
        prefixTree.insert("abc");
        prefixTree.insert("abc");
        prefixTree.insert("abcd");
        prefixTree.delete("abcd");
        System.out.println(prefixTree.search("abcd"));
    }
}
