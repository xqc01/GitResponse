package cn.xqc.code_tree;

import java.util.Stack;

/**
 * 使用栈结构完成树的遍历
 */
public class StackAndTree {
    /**
     * 使用栈结构前序遍历
     * 节点入栈时，打印
     *
     * @param head
     */
    public void preOrder(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        System.out.println(head);
        TreeNode pop = null;
        while (!stack.isEmpty()) {
            head = stack.peek();
            if (head.left != null && head.left != pop && head.right != pop) {
                stack.push(head.left);
                System.out.println(head.left);
            } else if (head.right != null && head.right != pop) {
                stack.push(head.right);
                System.out.println(head.right);
            } else {
                pop = stack.pop();
            }
        }
    }

    /**
     * 中序遍历：按照递归序遍历节点，在第二次访问该节点时，打印节点
     * 当遍历完节点的左子树后，回到父节点，准备遍历右子树时，打印父节点
     *
     * @param head
     */
    public void midOrder(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pop = null;
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.peek();
            if (head.left != null && head.left != pop && head.right != pop) {
                stack.push(head.left);
            //为了确保可以进入该分支，打印节点
            } else if (head.left == null || head.left == pop) {
                System.out.println(head);
                //如果有右子树，处理右子树，没有则该节点直接弹出
                if (head.right != null)
                    stack.push(head.right);
                else pop = stack.pop();
            } else {
                pop = stack.pop();
            }
        }
    }
    public void afterOrder(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode pop = null;
        while (!stack.isEmpty()) {
            head = stack.peek();
            if (head.left != null && head.left != pop && head.right != pop) {
                stack.push(head.left);
            } else if (head.right != null && head.right != pop) {
                stack.push(head.right);
            } else {
                pop = stack.pop();
                System.out.println(pop);
            }
        }
    }
}
