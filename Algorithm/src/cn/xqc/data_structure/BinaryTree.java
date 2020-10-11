package cn.xqc.data_structure;

/**
 * 二叉树
 */
public class BinaryTree {

}

/**
 * 二叉树的节点
 */
class TreeNode {
    private int key;
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    //中序遍历
    public void midOrder(){
        if (this.left != null)
            this.left.midOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.midOrder();
    }

    //后序遍历
    public void postOrder(){
        if (this.left != null)
            this.left.postOrder();
        if (this.right != null)
            this.right.postOrder();
        System.out.println(this);
    }
}
