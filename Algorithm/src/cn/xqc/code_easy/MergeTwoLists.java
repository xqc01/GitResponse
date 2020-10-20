package cn.xqc.code_easy;

/**
 * 合并有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(head == null){
                    head = l1;
                    tail = l1;
                }else{
                    tail.next = l1;
                    tail = tail.next;
                }
                l1 = l1.next;
            }else{
                if(head == null){
                    head = l2;
                    tail = l2;
                }else{
                    tail.next = l2;
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }
        if(l1 != null){
            if(head != null){
                tail.next = l1;
            }else
                head = l1;
        }
        if(l2 != null){
            if(head != null){
                tail.next = l2;
            }else
                head = l2;
        }
        return head;
    }
}
