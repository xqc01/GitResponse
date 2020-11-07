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

    //打印二叉树:本质是递归序遍历  右  头  左
    public static void printTree(TreeNode head){
        if (head == null)
            return;
        int level = 1;
        order(level,head);
    }
    public static void order(int level, TreeNode head){
        if (head == null)
            return;
        order(level+1,head.right);
        System.out.println(generateSpace(level)+head.value);
        order(level+1,head.left);
    }
    public static String generateSpace(int i){
        String str = "";
        for (int n = 0; n < i; n++){
            str = str + "    ";
        }
        return str;
    }
}
