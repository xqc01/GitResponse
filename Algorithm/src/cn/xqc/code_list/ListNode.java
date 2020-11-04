package cn.xqc.code_list;

import java.util.Objects;

/**
 * 单向链表节点
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;

        ListNode node = (ListNode) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }

    /**
     * 生成有环链表
     *
     * @param arr   将要转换为链表的数组
     * @param index 入环节点下标
     * @return 链表头节点
     */
    public static ListNode generateLoopList(int[] arr, int index) {
        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new ListNode(arr[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        nodes[nodes.length - 1].next = nodes[index];
        return nodes[0];
    }
}
