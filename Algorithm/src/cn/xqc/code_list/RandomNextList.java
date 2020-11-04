package cn.xqc.code_list;

import java.util.HashMap;

/**
 * 给定一个链表的头节点，该链表为单向链表，但是节点中含有random属性，随机指向某个节点
 * 复制该链表
 */
public class RandomNextList {
    /**
     * 笔试写法：使用hashmap
     * key中存放原链表节点，value中存放复制的链表节点
     * 设置value的next指针，再根据key的random指向，设置value的random指向
     */
    public RandomNextListNode copyList(RandomNextListNode head) {
        HashMap<RandomNextListNode, RandomNextListNode> hashMap = new HashMap<>();
        RandomNextListNode temp = head;
        while (temp != null) {
            hashMap.put(temp, new RandomNextListNode(temp.value));
            temp = temp.next;
        }

        //连接相应的next指针
        temp = head;
        RandomNextListNode tempNext = head.next;
        while (tempNext != null) {
            hashMap.get(temp).next = hashMap.get(tempNext);
            temp = temp.next;
            tempNext = tempNext.next;
        }

        //连接对应的random指针
        temp = head;
        while (temp != null) {
            hashMap.get(temp).random = hashMap.get(temp.random);
            temp = temp.next;
        }
        return hashMap.get(head);
    }

    /**
     * 面试使用：将复制后的节点放在原节点的next，
     * 例如：原链表1，2，3    复制节点之后链表1，1，2，2，3，3
     * 而后将链表中复制节点的random指针补全
     * 分离链表
     *
     * @param head 原链表的头节点
     * @return 返回复制后链表的头节点
     */
    public RandomNextListNode copyList2(RandomNextListNode head) {
        if (head == null)
            return null;
        //生成复制链表
        RandomNextListNode cur = head;
        while (cur != null){
            RandomNextListNode temp = cur.next;
            cur.next = new RandomNextListNode(cur.value);
            cur.next.next = temp;
            cur = temp;
        }
        //设置复制节点的random指针
        cur = head;
        while (cur != null){
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //分离链表
        cur = head;
        RandomNextListNode copyHead = head.next;
        while (cur != null){
            RandomNextListNode curNext = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            curNext.next = curNext.next == null ? null : curNext.next.next;
            curNext = curNext.next;
        }
        return copyHead;
    }
}

class RandomNextListNode {
    public int value;
    public RandomNextListNode next;
    public RandomNextListNode random;

    public RandomNextListNode() {
    }

    public RandomNextListNode(int value) {
        this.value = value;
    }

    //生成随机链表，返回头节点
    public static RandomNextListNode generateList(int length) {
        //定义数组
        RandomNextListNode[] nodes = new RandomNextListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new RandomNextListNode(i);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        //生成随机值
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * 10000) % length;
            nodes[i].random = nodes[randomIndex];
        }
        return nodes[0];
    }

    //输出链表
    public static void print(RandomNextListNode head) {
        while (head != null) {
            System.out.println("RandomNextListNode   value = " + head.value + " next = " + head.next + " random = " + head.random);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
