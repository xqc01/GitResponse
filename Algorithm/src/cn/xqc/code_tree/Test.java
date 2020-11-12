package cn.xqc.code_tree;

import cn.xqc.data_structure.BinaryTree;

import javax.tools.Tool;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        BinaryTreeQuestion binaryTreeQuestion = new BinaryTreeQuestion();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        TreeNode node = Tools.generateTree(arr);

        Tools.printTree(node);
    }
}
