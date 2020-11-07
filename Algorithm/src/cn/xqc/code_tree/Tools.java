package cn.xqc.code_tree;

import java.util.Queue;

public class Tools {

    //根据数组生成完全二叉树
    public static TreeNode generateTree(int[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        for (int i = 0; i <= (arr.length - 2) / 2; i++) {
            nodes[i].left = nodes[i * 2 + 1];
            nodes[i].right = (i * 2 + 2) == arr.length ? null : nodes[i * 2 + 2];
        }
        return nodes[0];
    }

    //遍历队列
    public static void printQueue(Queue queue){
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
