package cn.xqc.code_easy;

/**
 * 反转链表
 * 使用双指针，遍历整个链表
 */
public class InvertedList {
    public ListNode ReverseList(ListNode head) {
        //链表长度为0或1直接返回
        if(head == null)
            return head;
        if(head.getNext() == null)
            return head;

        ListNode pre = null;
        ListNode post = head;

        while(post.getNext() != null){
            ListNode temp = post.getNext();
            post.setNext(pre);
            pre = post;
            post = temp;
        }
        post.setNext(pre);
        return post;
    }
}
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
