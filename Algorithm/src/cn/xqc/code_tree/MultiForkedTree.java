package cn.xqc.code_tree;

import java.util.List;

/**
 * 多叉树节点结构
 */
public class MultiForkedTree<T> {
    public int value;
    public List<T> next;

    public MultiForkedTree() {
    }

    public MultiForkedTree(int value) {
        this.value = value;
    }
}
