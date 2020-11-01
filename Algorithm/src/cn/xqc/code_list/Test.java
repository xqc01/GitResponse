package cn.xqc.code_list;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        FastSlowPointer fastSlowPointer = new FastSlowPointer();
//        System.out.println(fastSlowPointer.findMid(head));
//        System.out.println(fastSlowPointer.findMid2(head));
//        System.out.println(fastSlowPointer.forceFindMid(head));
//        ListNode head = new ListNode(0);
//        ListNode tail = head;
//        for (int i = 1; i < 10; i++) {
//            tail.next = new ListNode(i);
//            tail = tail.next;
//        }
//        System.out.println();
//        while (head != null){
//            System.out.println(head);
//            head = head.next;
//        }
//        HuiLanguage huiLanguage = new HuiLanguage();
//        System.out.println(huiLanguage.isHui(node1));
//        System.out.println(huiLanguage.isHui2(node1));
//        System.out.println();
//        Tools.printList(node1);
//        Tools.printList(node);
//        System.out.println();
//        System.out.println(huiLanguage.isHui3(node));
//        ListNode node1 = huiLanguage.reverseList(node);
//        Tools.printList(node1);
        int[] arr = {1, 2, 3, 3, 1, 1, 4, 6, 7, 6, 3, 8, 8, 9, 6};
        ListNode node = Tools.arrayToList(arr);
//        System.out.println(Arrays.toString(Tools.listToArray(node)));
        HollandFlagList hollandFlagList = new HollandFlagList();
        Tools.printList(hollandFlagList.partition2(node, 3));
    }
}
