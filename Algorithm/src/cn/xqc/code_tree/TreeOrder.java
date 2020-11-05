package cn.xqc.code_tree;

/**
 * 二叉树的遍历：
 *      前中后序遍历其本质是递归序；树中的每个节点都会被访问三次
 *      前序遍历时，第一次访问该节点时打印
 *      中序遍历时，第二次访问该节点时打印
 *      后序遍历时，第三次访问该节点时打印
 */
public class TreeOrder {
    public void pre(TreeNode head){
        if (head == null)
            return;
        System.out.print(head.value+" ");
        pre(head.left);
        pre(head.right);
    }
    public void preOrder(TreeNode head){
        if (head == null)
            return;
        System.out.println(head);
        preOrder(head.left);
        preOrder(head.right);
    }
    public void midOrder(TreeNode head){
        if (head == null)
            return;
        midOrder(head.left);
        System.out.println(head);
        midOrder(head.right);
    }
    public void afterOrder(TreeNode head){
        if (head == null)
            return;
        afterOrder(head.left);
        afterOrder(head.right);
        System.out.println(head);
    }
}
