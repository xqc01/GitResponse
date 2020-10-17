package cn.xqc.data_structure;

/**
 * 使用双向链表实现队列
 */
public class MyLinkedQueue {
    public QueueAndStackNode queueAndStackNode;

    public MyLinkedQueue() {
        this.queueAndStackNode = new QueueAndStackNode();
    }

    public void push(Node node) {
        queueAndStackNode.addFromHead(node);
    }

    public Node pop() {
        return queueAndStackNode.removeFromTail();
    }

    //遍历队列
    public void print() {
        Node head = queueAndStackNode.head;
        Node tail = queueAndStackNode.tail;
        while (head != tail) {
            System.out.println(tail);
            tail = tail.last;
        }
        System.out.println(head);
    }
}
