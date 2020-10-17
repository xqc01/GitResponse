package cn.xqc.data_structure;

/**
 * 使用双向链表实现栈结构
 */
public class MyLinkedStack {
    public QueueAndStackNode queueAndStackNode;

    public MyLinkedStack() {
        queueAndStackNode = new QueueAndStackNode();
    }

    public void push(Node node) {
        queueAndStackNode.addFromHead(node);
    }

    public Node pop() {
        return queueAndStackNode.removeFromHead();
    }

    //遍历栈
    public void print() {
        Node head = queueAndStackNode.head;
        Node tail = queueAndStackNode.tail;
        while (head != tail) {
            System.out.println(head);
            head = head.next;
        }
        System.out.println(tail);
    }
}
