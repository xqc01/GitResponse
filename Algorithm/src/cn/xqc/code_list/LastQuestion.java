package cn.xqc.code_list;

import java.util.List;

/**
 * 最后一个链表问题：有两个有环或者无环的链表，判断两个链表是否相交
 * 分析：链表中的节点只有一个next指针，所以首先判断链表是否有环，并返回入环节点
 * 如果都无环，则查看链表最后一个节点是否相等，相等则链表相交
 * 如果一个有环，一个无环，必定不相交
 * 如果两个都有环：
 * 判断入环节点是否相等，相等则相交
 * 如果入环节点不相等，则让某个入环节点遍历环内节点一周，如果环内有节点和另一个入环节点相等，则相交
 */
public class LastQuestion {
    public ListNode isMeet(ListNode head1, ListNode head2) {
        ListNode loop1 = this.isLoop(head1);
        ListNode loop2 = this.isLoop(head2);
        if (loop1 == null && loop2 == null)
            return this.noLoopIsMeet(head1, head2);
        if (loop1 != null && loop2 != null) {
            return this.loopIsMeet(head1,head2);
        }
        return null;
    }

    /**
     * 判断链表的头节点使用否有环，并返回入环节点
     * 使用快慢指针，若快慢指针相遇，则有环，若快指针走到null，则无环
     * <p>
     * 判断入环节点：快慢指针相遇的地方，让快指针回到头节点，每次走一步，再次和慢指针相遇，此处就是入环节点
     * 证明：设环外节点个数a，环内节点个数b，慢指针走一步1t，快指针走两步2t，快慢指针相遇时在环内走n步
     * t = a + n；  2t = a + b + n;  所以t = b;   a + n = b;
     * 那么此时慢指针位于环内距离入环节点 b - n 的位置
     * 快指针此时回到头节点，位于距离入环节点 a 的位置
     *
     * @param head 给定链表头节点
     * @return 若有环，返回入环节点，无环返回null
     */
    public ListNode isLoop(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            if (slow == fast)
                break;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null)
            return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 判断两个无环链表是否相交，若相交返回相交节点，不相交，返回null
     * 如何返回相交节点：
     * 遍历两个链表，得到链表的长度差n，长的链表先走n步，
     * 而后两个链表一同向下遍历，遇到相同节点，则该节点是链表相交节点
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode noLoopIsMeet(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;
        ListNode end1 = head1;
        ListNode end2 = head2;
        //两个链表的长度差值
        int n = 0;
        while (end1.next != null) {
            end1 = end1.next;
            n++;
        }
        while (end2.next != null) {
            end2 = end2.next;
            n--;
        }
        if (end1 != end2)
            return null;
        //使head1作为长链表的头节点，head2作为短链表的头节点
        if (n < 0) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        //取n的绝对值
        n = Math.abs(n);
        while (n > 0) {
            head1 = head1.next;
            n--;
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    /**
     * 两个有环链表，判断是否相交
     * 先找到两个链表的入环节点，节点相同，则一定相交
     * 若节点不同，则一个节点遍历环内节点，若有和另一个节点相等的节点，则相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode loopIsMeet(ListNode head1, ListNode head2) {
        ListNode loop1 = this.isLoop(head1);
        ListNode loop2 = this.isLoop(head2);
        if (loop1 == loop2) {
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                cur1 = cur1.next;
                n++;
            }
            while (cur2 != loop2) {
                cur2 = cur2.next;
                n--;
            }
            if (n < 0) {
                ListNode temp = head1;
                head1 = head2;
                head2 = temp;
            }
            n = Math.abs(n);
            while (n > 0) {
                n--;
                head1 = head1.next;
            }
            while (head1 != head2){
                head1 = head1.next;
                head2 = head2.next;
            }
            return head1;
        }else {
            ListNode end = loop1;
            loop1 = loop1.next;
            while (loop1 != end){
                if (loop1 == loop2)
                    return loop2;
                else return null;
            }
            return null;
        }
    }
}
