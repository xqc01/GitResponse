package cn.xqc.code_hard;

/**
 * 将给出的链表中的节点每k个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度O(1)
 * <p>
 * 例如：
 * 给定的链表是
 * 1→2→3→4→5
 * 对于k=2, 你应该返回2→1→4→3→5
 * 对于k=3, 你应该返回3→2→1→4→5
 */
public class InvertedKthLinked {
    public ListNode reverseKGroup(ListNode head, int k) {
        System.out.println("输入的k=" + k);
        ListNode pre = null;
        ListNode cur = head;
        ListNode tempHead = head;//临时的头节点
        if (head == null || head.getNext() == null)
            return head;
        int length = 0;
        while (tempHead != null) {
            //记录临时头节点
            ListNode record = tempHead;
            //根据链表长度判断是否反转
            while (tempHead != null) {
                tempHead = tempHead.getNext();
                length++;
                if (length % k == 0)
                    break;
            }
            if (length % k != 0) {
                System.out.println("从36行返回");
                return head;
            }
            //此时可以进行反转
            System.out.println("反转时的length=" + length + " tempHead=" + tempHead);
            while (cur != null && cur != tempHead) {
                ListNode temp = cur.getNext();
                cur.setNext(pre);
                pre = cur;
                cur = temp;
            }
            //反转完成
            if (length / k == 1)
                head = pre;
            pre = record;
            System.out.println("反转后的头节点");
            Tools.printList(head);
            System.out.println("------------------------");
        }
        return head;
    }
}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
