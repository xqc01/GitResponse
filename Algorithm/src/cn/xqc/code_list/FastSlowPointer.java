package cn.xqc.code_list;

import java.util.ArrayList;

/**
 * 链表中使用快慢指针
 */
public class FastSlowPointer {
    //给定一个链表头节点，若是奇数个返回链表中间节点，若是偶数个返回靠前中间的节点
    public ListNode findMid(ListNode node) {
        if (node == null)
            return null;
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //条件同上，但是偶数个返回靠后的中间节点
    public ListNode findMid2(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        if (node == null)
            return null;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return slow;
    }

    //快慢指针问题的暴力解法：使用ArrayList
    public ListNode forceFindMid(ListNode node) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int index = list.size() / 2 - 1;
        return list.get(index);
    }
}
