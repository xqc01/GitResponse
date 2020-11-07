package cn.xqc.code_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化
 * 对树进行序列化时，树的叶子节点指向的空指针null同样要保存
 * 例如：     0
 *        1      2
 *    3
 * 按层序列化为0，1，2，3，null，null，null，null，null
 */
public class TreeSerializable {
    /**
     * 二叉树的前序 序列化
     * @param head
     * @return
     */
    public Queue<TreeNode> preOrderSerializable(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        preOS(head,queue);
        return queue;
    }
    public void preOS(TreeNode head, Queue<TreeNode> queue){
        queue.add(head);
        if (head == null)
            return;
        preOS(head.left,queue);
        preOS(head.right,queue);
    }

    /**
     * 二叉树的中序序列化
     * @param head
     * @return
     */
    public Queue<TreeNode> midOrderSerializable(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        midOS(head,queue);
        return queue;
    }
    public void midOS(TreeNode head, Queue<TreeNode> queue){
        if (head == null){
            queue.add(head);
            return;
        }
        midOS(head.left,queue);
        queue.add(head);
        midOS(head.right,queue);
    }

    /**
     * 后序遍历 序列化
     * @param head
     * @return
     */
    public Queue<TreeNode> afterOrderSerializable(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        afterOS(head,queue);
        return queue;
    }
    public void afterOS(TreeNode head, Queue<TreeNode> queue){
        if (head == null){
            queue.add(head);
            return;
        }
        afterOS(head.left,queue);
        afterOS(head.right,queue);
        queue.add(head);
    }

    /**
     * 二叉树的广度优先遍历 序列化
     * @param head
     * @return
     */
    public Queue<TreeNode> levelSerializable(TreeNode head){
        Queue<TreeNode> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        result.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            result.add(poll.left);
            result.add(poll.right);
            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
        return result;
    }
}
