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
//        int[] arr = {1, 2, 3, 3, 1, 1, 4, 6, 7, 6, 3, 8, 8, 9, 6};
//        ListNode node = Tools.arrayToList(arr);
//        System.out.println(Arrays.toString(Tools.listToArray(node)));
//        HollandFlagList hollandFlagList = new HollandFlagList();
//        Tools.printList(hollandFlagList.partition2(node, 3));
//        RandomNextList randomNextList = new RandomNextList();
//        RandomNextListNode randomNextListNode = RandomNextListNode.generateList(10);
//        RandomNextListNode randomNextListNode1 = randomNextList.copyList2(randomNextListNode);
//        RandomNextListNode.print(randomNextListNode1);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {2, 2, 3, 6, 7, 9};
        int[] arr3 = {3, 2, 6, 9, 4};
        ListNode node1 = Tools.arrayToList(arr);
        ListNode node2 = Tools.arrayToList(arr2);
        ListNode node3 = Tools.arrayToList(arr3);
        ListNode node4 = ListNode.generateLoopList(arr,4);
        node3 = Tools.linkList(node3,node4);
        node1 = Tools.linkList(node1,node3);
        node2 = Tools.linkList(node2,node3);
        LastQuestion lastQuestion = new LastQuestion();
        System.out.println(lastQuestion.isMeet(node1, node2));
//        System.out.println(lastQuestion.noLoopIsMeet(node1, node2));
//        Tools.printList(node, 10);
//        ListNode loop = lastQuestion.isLoop(node);
//        System.out.println();
    }
}
