package cn.xqc.code_tree;

import java.util.*;

/**
 * 二叉树的遍历：
 * 前中后序遍历其本质是递归序；树中的每个节点都会被访问三次
 * 前序遍历时，第一次访问该节点时打印
 * 中序遍历时，第二次访问该节点时打印
 * 后序遍历时，第三次访问该节点时打印
 */
public class TreeOrder {
    public void pre(TreeNode head) {
        if (head == null)
            return;
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public void preOrder(TreeNode head) {
        if (head == null)
            return;
        System.out.println(head);
        preOrder(head.left);
        preOrder(head.right);
    }

    public void midOrder(TreeNode head) {
        if (head == null)
            return;
        midOrder(head.left);
        System.out.println(head);
        midOrder(head.right);
    }

    public void afterOrder(TreeNode head) {
        if (head == null)
            return;
        afterOrder(head.left);
        afterOrder(head.right);
        System.out.println(head);
    }

    /**
     * 二叉树按层遍历(广度优先遍历)，使用队列
     * 首先二叉树的头节点入队列，而后判断队列不为空，执行循环
     * 队列中的节点出栈后打印，而后其子节点入栈
     */
    public void layerTraversal(TreeNode head) {
        if (head == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            System.out.println(temp);
        }
    }

    /**
     * 二叉树的广度优先遍历，并返回树的宽度，主要在于建立层结束返回机制
     * 使用hashmap结构，储存树的节点和对应的层数
     *
     * @param head
     * @return
     */
    public int layerTraversal1(TreeNode head) {
        //使用队列，按层遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //要返回的最大宽度
        int max = 0;
        //建立map表，key = 节点， value = 节点所在层数
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        //当前层节点数
        int levelNodes = 0;
        //当前层数
        int level = 1;

        queue.add(head);
        hashMap.put(head, level);
        while (!queue.isEmpty()) {
            //进行按层遍历，并在hashmap中记录各节点所在层数
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                hashMap.put(poll.left, hashMap.get(poll)+1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                hashMap.put(poll.right, hashMap.get(poll)+1);
            }

            //判断队列中出来的节点是否在本层，如果不在，就说明该层节点统计完毕
            if ((int) hashMap.get(poll) == level) {
                levelNodes++;
            } else {
                level++;
                max = Math.max(levelNodes, max);
                levelNodes = 1;
            }
        }
        max = Math.max(max, levelNodes);
        return max;
    }
    /**
     * 二叉树广度优先遍历，返回树的宽度，不使用map表
     */
    public int layerTraversal2(TreeNode head){
        int max = 0;
        int levelNodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //当前层的结束位置
        TreeNode end = head;
        //下一层的结束位置
        TreeNode nextEnd = null;

        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if (poll.right != null){
                queue.add(poll.right);
                nextEnd = poll.right;
            }

            levelNodes++;
            if (poll == end){
                end = nextEnd;
                max = Math.max(max,levelNodes);
                levelNodes = 0;
            }
        }
        return max;
    }
}
