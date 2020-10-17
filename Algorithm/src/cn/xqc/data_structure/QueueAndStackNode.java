package cn.xqc.data_structure;

/**
 * 队列和数组底层的node节点,使用双向链表
 */
public class QueueAndStackNode {
    public Node head;
    public Node tail;

    public QueueAndStackNode() {
        this.head = null;
        this.tail = null;
    }

    //从头部插入数据
    public void addFromHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        } else {
            head.last = node;
            node.next = head;
            head = node;
        }
    }

    public Node removeFromHead() {
        Node result;
        if (head == null)
            throw new RuntimeException("没有数据，无法删除");
        else {
            result = head;
            head = head.next;
            head.last = null;
        }
        return  result;
    }

    //从尾部插入数据
    public void addFromTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
    }

    public Node removeFromTail() {
        Node result;
        if (head == null)
            throw new RuntimeException("没有数据");
        else {
            result = tail;
            tail = tail.last;
            tail.next = null;
        }
        return result;
    }
}

class Node {
    public int value;
    public Node last;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //遍历链表
    public void print() {
        Node temp = this;
        while (temp != null) {
            System.out.println(temp);
            temp = next;
        }
    }
}
