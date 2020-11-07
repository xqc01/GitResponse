package cn.xqc.code_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的反序列化
 */
public class TreeDeserializable {
    /**
     * 前序 反序列化
     * @param queue
     * @return
     */
    public TreeNode preDeserializable(Queue<TreeNode> queue){
        return preDS(queue);
    }
    public TreeNode preDS(Queue<TreeNode> queue){
        TreeNode poll = queue.poll();
        if (poll == null)
            return null;
        poll.left = preDS(queue);
        poll.right = preDS(queue);
        return poll;
    }
//二叉树的中序反序列化
//    public TreeNode midDeserializable(Queue<TreeNode> queue){
//        if (queue.isEmpty())
//            return null;
//        return midDS(queue);
//    }
//    public TreeNode midDS(Queue<TreeNode> queue){
//        TreeNode poll = new TreeNode();
//        poll.left = midDS(queue);
//        poll = queue.poll();
//        if (poll == null) {
//            return null;
//        }
//        poll.right = midDS(queue);
//    }

    public TreeNode levelDeserializable(Queue<TreeNode> queue){
        if (queue.isEmpty())
            return null;
        //二叉树按层遍历所需队列
        Queue<TreeNode> queue1 = new LinkedList<>();
        TreeNode head = queue.poll();
        TreeNode cur = head;
        queue1.add(cur);
        while (!queue1.isEmpty()){
            cur = queue1.poll();
            cur.left = queue.poll();
            cur.right = queue.poll();
            if (cur.left != null)
                queue1.add(cur.left);
            if (cur.right != null)
                queue1.add(cur.right);
        }
        return head;
    }
}
