package cn.xqc.code_easy;

/**
 * 删除链表中倒数第n个节点
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 *  给出的链表为:1->2->3->4->5, n= 2.
 *  删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是有效的
 * 请给出请给出时间复杂度为O(n)的算法
 */
public class RemoveCountDownKth {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode remove = head;
        ListNode last = head;
        int length = 0;

        while(last != null){
            last = last.next;
            length++;
            if(length > (n+1)){
                remove = remove.next;
            }
        }
        if(length > n){
            remove.next = remove.next.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
