package cn.xqc.code_hard;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        InvertedKthLinked i = new InvertedKthLinked();
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(14);
        ListNode node5 = new ListNode(15);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        Tools.printList(node1);
        i.reverseKGroup(node1, 2);
        Tools.printList(node1);

    }
}
