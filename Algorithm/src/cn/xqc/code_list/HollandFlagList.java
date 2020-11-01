package cn.xqc.code_list;

import java.util.Arrays;

/**
 * 链表的荷兰国旗问题
 * 给定一个链表的头节点，再给定一个值，将链表分为小于区，等于区，大于区，返回头节点
 */
public class HollandFlagList {
    //暴力解法：将链表转化为数组，排好序后再转化为链表
    public ListNode partition(ListNode head, int value) {
        int[] arr = Tools.listToArray(head);
        int less = -1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i] < value) {
                Tools.swap(arr, i++, ++less);
            } else if (arr[i] > value) {
                Tools.swap(arr, i, --more);
            } else
                i++;
        }
        head = Tools.arrayToList(arr);
        return head;
    }

    //每个区域使用两个节点记录头尾，形成新的链表
    public ListNode partition2(ListNode head, int value) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalsHead = null;
        ListNode equalsTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;

        //遍历链表
        while (head != null) {
            ListNode temp = head;
            if (head.value < value) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else if (head.value == value) {
                if (equalsHead == null) {
                    equalsHead = head;
                    equalsTail = head;
                } else {
                    equalsTail.next = head;
                    equalsTail = equalsTail.next;
                }
            } else {
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = moreTail.next;
                }
            }
            head = temp.next;
        }
        lessTail.next = null;
        equalsTail.next = null;
        moreTail.next = null;
//        System.out.println(lessHead);
//        System.out.println(lessTail);
//        System.out.println(equalsHead);
//        System.out.println(equalsTail);
//        System.out.println(moreHead);
//        System.out.println(moreTail);
//        Tools.printList(lessHead);
//        Tools.printList(equalsHead);
//        Tools.printList(moreHead);
        //将三个链表连起来，注意可能为空
        if (lessHead == null){
            if (equalsHead == null){
                return moreHead;
            }
            else {
                head = equalsHead;
                equalsTail.next = moreHead;
            }
        }else {
            head = lessHead;
            if (equalsHead == null){
                lessTail.next = moreHead;
            }else {
                lessTail.next = equalsHead;
                equalsTail.next = moreHead;
            }
        }
        return head;
    }
}
