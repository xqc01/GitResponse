package cn.xqc.code_tree;

/**
 * 中序遍历问题  前驱后继
 */
public class MidOrderTraversing {
    /**
     * 返回一个节点的前驱节点
     * 前驱节点：中序遍历顺序时，遍历结果中，该节点的前一个节点
     * @param node
     * @return
     */
    public TreeNodeParent pioneer(TreeNodeParent node){
        if (node == null)
            return null;
        if (node.left != null){
            return findFarRight(node.left);
        }
        //如果node没有左子树，就去找父节点，并判断node是不是父节点的右孩子
        TreeNodeParent parent = node.parent;
        while (parent != null){
            if (parent.right == node)
                return parent;
            node = parent;
            parent = parent.parent;
        }
        return null;
    }
    public TreeNodeParent findFarRight(TreeNodeParent head){
        if (head.right == null)
            return head;
        return findFarRight(head.right);
    }

    /**
     * 返回节点的后继节点
     * @param node
     * @return
     */
    public TreeNodeParent successor(TreeNodeParent node){
        if (node == null)
            return null;
        if (node.right != null)
            return findFarLeft(node.left);
        TreeNodeParent parent = node.parent;
        while (parent != null){
            if (parent.left == node)
                return parent;
            node = parent;
            parent = parent.parent;
        }
        return null;
    }
    public TreeNodeParent findFarLeft(TreeNodeParent head){
        if (head.left == null)
            return head;
        return findFarLeft(head.left);
    }
}
