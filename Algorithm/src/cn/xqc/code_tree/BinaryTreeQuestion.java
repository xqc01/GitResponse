package cn.xqc.code_tree;

import java.time.temporal.IsoFields;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树相关问题
 */
public class BinaryTreeQuestion {
    /**
     * 判断是否为满二叉树
     *
     * @param head
     * @return
     */
    public Boolean isFull(TreeNode head) {
        if (head == null) {
            return true;
        }
        IsFullInfo fullProcess = isFullProcess(head);
        int nodes = 1;
        for (int i = 0; i < fullProcess.height; i++) {
            nodes = nodes * 2;
        }
        nodes--;
        return nodes == fullProcess.nodes;
    }

    public IsFullInfo isFullProcess(TreeNode head) {
        if (head == null)
            return new IsFullInfo(0, 0);
        IsFullInfo process1 = isFullProcess(head.left);
        IsFullInfo process2 = isFullProcess(head.right);

        int height = Math.max(process1.height, process2.height) + 1;
        int nodes = process1.nodes + process2.nodes + 1;
        return new IsFullInfo(height, nodes);
    }

    /**
     * 判断是否为完全二叉树 使用递归序
     *
     * @param head
     * @return
     */
    public boolean isComplete(TreeNode head) {
        if (head == null)
            return true;
        IsCompleteInfo completeProcess = isCompleteProcess(head);
        return completeProcess.isComplete;
    }

    public IsCompleteInfo isCompleteProcess(TreeNode head) {
        if (head == null)
            return new IsCompleteInfo(true, true, 0);
        IsCompleteInfo completeProcess = isCompleteProcess(head.left);
        IsCompleteInfo completeProcess1 = isCompleteProcess(head.right);

        boolean isFull = false;
        if (completeProcess.isFull && completeProcess1.isFull && completeProcess.height == completeProcess1.height)
            isFull = true;
        boolean isComplete = false;
        if (isFull)
            isComplete = true;
        if (completeProcess.isFull && completeProcess1.isFull && completeProcess.height >= completeProcess1.height && completeProcess.height - completeProcess1.height <= 1)
            isComplete = true;
        if (completeProcess.isComplete && completeProcess1.isFull && completeProcess.height - completeProcess1.height == 1)
            isComplete = true;
        if (completeProcess.isFull && completeProcess1.isComplete && completeProcess.height == completeProcess1.height)
            isComplete = true;
        int height = Math.max(completeProcess.height, completeProcess1.height) + 1;
        return new IsCompleteInfo(isFull, isComplete, height);
    }

    /**
     * 判断是否为完全二叉树，使用按层遍历的方法
     *
     * @param head
     * @return
     */
    public boolean isComplete2(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        //标记位，表示此时的节点可以有子节点
        boolean mark = true;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //如果一个节点有右孩子却没有左孩子，返回false
            if (poll.left == null && poll.right != null)
                return false;
            //当标记位表示不可以有子节点时，该节点有孩子，返回false
            if (mark == false)
                if (poll.left != null || poll.right != null)
                    return false;
            if (poll.left == null) {
                mark = false;
            } else {
                queue.add(poll.left);
            }
            if (poll.right == null) {
                mark = false;
            } else {
                queue.add(poll.right);
            }
        }
        return true;
    }

    /**
     * 寻找公共祖先
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode findCommonAncestors(TreeNode head, TreeNode node1, TreeNode node2) {
        return findProcess(head, node1, node2).commonAncestors;
    }

    public FindInfo findProcess(TreeNode head, TreeNode node1, TreeNode node2) {
        if (head == null)
            return new FindInfo(false, false, null);
        FindInfo process = findProcess(head.left, node1, node2);
        FindInfo process1 = findProcess(head.right, node1, node2);

        boolean containNode1 = false;
        if (process.containNode1 || process1.containNode1 || head == node1)
            containNode1 = true;

        boolean containNode2 = false;
        if (process.containNode2 || process1.containNode2 || head == node2)
            containNode2 = true;

        TreeNode commonAncestors = null;
        if (process.commonAncestors != null)
            commonAncestors = process.commonAncestors;
        if (process1.commonAncestors != null)
            commonAncestors = process1.commonAncestors;
        if (process.containNode1 && process1.containNode2)
            commonAncestors = head;
        if (process.containNode2 && process1.containNode1)
            commonAncestors = head;
        if (head == node1 && (process.containNode2 || process1.containNode2))
            commonAncestors = head;
        if (head == node2 && (process.containNode1 || process1.containNode1))
            commonAncestors = head;

        return new FindInfo(containNode1, containNode2, commonAncestors);
    }

    /**
     * 寻找公共祖先，使用map表记录节点的父节点  set表先记录node1的所有父节点，然后用node2的父节点对比
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode findCommonAncestors2(TreeNode head, TreeNode node1, TreeNode node2) {
        //key 当前节点，  value 父节点
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
        hashMap.put(head, null);
        this.fillInMap(head, hashMap);

        HashSet<TreeNode> hashSet = new HashSet<>();
        hashSet.add(node1);
        TreeNode cur = hashMap.get(node1);
        while (cur != null) {
            hashSet.add(cur);
            cur = hashMap.get(cur);
        }
        cur = node2;
        while (cur != null){
            if (hashSet.contains(cur))
                return cur;
            cur = hashMap.get(cur);
        }
        return null;
    }

    public void fillInMap(TreeNode head, HashMap<TreeNode, TreeNode> hashMap) {
        if (head.left == null && head.right == null)
            return;
        if (head.left != null)
            hashMap.put(head.left, head);
        if (head.right != null)
            hashMap.put(head.right, head);
        fillInMap(head.left, hashMap);
        fillInMap(head.right, hashMap);
    }
}

class FindInfo {
    public boolean containNode1;
    public boolean containNode2;
    public TreeNode commonAncestors;

    public FindInfo(boolean containNode1, boolean containNode2, TreeNode commonAncestors) {
        this.containNode1 = containNode1;
        this.containNode2 = containNode2;
        this.commonAncestors = commonAncestors;
    }
}

class IsCompleteInfo {
    public boolean isFull;
    public boolean isComplete;
    public int height;

    public IsCompleteInfo(boolean isFull, boolean isComplete, int height) {
        this.isFull = isFull;
        this.isComplete = isComplete;
        this.height = height;
    }
}

class IsFullInfo {
    //树的高度和节点个数
    public int height;
    public int nodes;

    public IsFullInfo(int height, int nodes) {
        this.height = height;
        this.nodes = nodes;
    }
}
