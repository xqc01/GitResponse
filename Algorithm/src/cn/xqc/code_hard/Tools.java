package cn.xqc.code_hard;

/**
 * 工具类
 */
public class Tools {

    /**
     * 遍历链表
     *
     * @param listNode 链表的头节点
     */
    public static void printList(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode + " ");
            listNode = listNode.getNext();
        }
        System.out.println(stringBuilder);
    }
}
