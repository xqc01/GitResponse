package cn.xqc.leetcode_easy;

/**
 * 判断链表是否有环：使用快慢指针，若快指针最终指向null，则无环；快指针追上慢指针，有环
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean has = false;
        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            if(fast == slow){
                has = true;
                break;
            }
            fast = fast.next;
            if(fast == null){
                break;
            }
            if(fast == slow){
                has = true;
                break;
            }
            slow = slow.next;
            if(slow == fast){
                has = true;
                break;
            }
        }
        return has;
    }
}
