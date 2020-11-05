package cn.xqc.code_tree;

import javax.tools.Tool;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode head = Tools.generateTree(arr);
        TreeOrder treeOrder = new TreeOrder();
        treeOrder.afterOrder(head);

        StackAndTree stackAndTree = new StackAndTree();
        stackAndTree.afterOrder(head);
    }
}
