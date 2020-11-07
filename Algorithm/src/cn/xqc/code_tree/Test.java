package cn.xqc.code_tree;

import javax.tools.Tool;
import java.io.Serializable;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode head = Tools.generateTree(arr);
        TreeOrder treeOrder = new TreeOrder();
        treeOrder.layerTraversal(head);
        System.out.println();

        TreeSerializable serializable = new TreeSerializable();
        Queue<TreeNode> queue = serializable.levelSerializable(head);

        TreeDeserializable treeDeserializable = new TreeDeserializable();
        TreeNode treeNode = treeDeserializable.levelDeserializable(queue);
        treeOrder.layerTraversal(treeNode);
    }
}
