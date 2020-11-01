package cn.xqc.code_list;

public class Tools {
    //将数组转换为单向链表，返回头节点
    public static ListNode arrayToList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    //将链表转化为数组
    public static int[] listToArray(ListNode head){
        int length = listSize(head);
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = head.value;
            head = head.next;
        }
        return arr;
    }

    //返回链表长度
    public static int listSize(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    //遍历链表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
        System.out.println();
    }

    //交换数组中的两个数
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
