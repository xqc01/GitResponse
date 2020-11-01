package cn.xqc.code_list;

import java.util.Stack;

/**
 * 判断链表是否是回文结构：例如1，2，3，3，2，1
 */
public class HuiLanguage {
    //暴力解法:使用栈结构，进栈后出栈
    public boolean isHui(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(head))
                return false;
            head = head.next;
        }
        return true;
    }

    //过度方法：使用快慢指针，找到链表的中间位置，然后将中间位置之后的链表放入栈中
    public boolean isHui2(ListNode head) {
        FastSlowPointer fastSlowPointer = new FastSlowPointer();
        ListNode mid = fastSlowPointer.findMid(head);
        Stack<ListNode> stack = new Stack<>();
        while (mid.next != null) {
            mid = mid.next;
            stack.push(mid);
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(head))
                return false;
            head = head.next;
        }
        return true;
    }

    //终极方法:找到链表的中间位置，该位置节点指向null，再将之后的将链表反转，左右节点向中间遍历，最后链表还原
    public boolean isHui3(ListNode head) {
        FastSlowPointer fastSlowPointer = new FastSlowPointer();
        //找到链表的中间节点
        ListNode mid = fastSlowPointer.findMid(head);
        //记录节点，为了之后还原链表
        ListNode left = head;
        //反转链表，返回头节点
        ListNode right = this.reverseList(mid);
        ListNode rightHead = right;
        boolean res = true;

        while (left != null && right != null) {
            if (!left.equals(right)) {
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        //还原链表
        ListNode node = this.reverseList(rightHead);
        if (mid != node)
            mid.next = node;
        Tools.printList(head);
        return res;
    }

    //反转链表,返回头节点
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode post = null;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = post;
            post = pre;
            pre = temp;
        }
        return post;
    }
}
