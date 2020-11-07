package cn.xqc.code_tree;

/**
 * 二叉树节点，有指向父节点的指针
 */
public class TreeNodeParent {
    public int value;
    public TreeNodeParent left;
    public TreeNodeParent right;
    public TreeNodeParent parent;
    public TreeNodeParent(){}

    public TreeNodeParent(int value) {
        this.value = value;
    }
}
