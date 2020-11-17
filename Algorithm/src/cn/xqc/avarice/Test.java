package cn.xqc.avarice;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        SetUpLights setUpLights = new SetUpLights();
//        String string = "XXXX...XX..XXXX.....XX";
//
//        ArrayList<Integer> arrayList = setUpLights.setUpLights(string);
//        for (Integer list : arrayList) {
//            System.out.print(list+" ");
//        }
//        System.out.println();
//        ArrayList<Integer> arrayList1 = setUpLights.setUpLights2(string);
//        for (Integer integer : arrayList1) {
//            System.out.print(integer+" ");
//        }

//        Meeting meeting = new Meeting(1, 3);
//        Meeting meeting1 = new Meeting(3, 5);
//        Meeting meeting2 = new Meeting(1, 2);
//        Meeting meeting3 = new Meeting(7, 9);
//        Meeting meeting4 = new Meeting(4, 5);
//        Meeting meeting5 = new Meeting(6, 7);
//        Meeting meeting6 = new Meeting(4, 6);
//        Meeting meeting7 = new Meeting(6, 8);
//        Meeting meeting8 = new Meeting(7, 9);
//        Meeting meeting9 = new Meeting(5, 7);
//        Meeting[] meetings = {meeting, meeting1, meeting2, meeting3, meeting4, meeting5, meeting6, meeting7, meeting8, meeting9};
//        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>((m1, m2) -> m2.end - m1.end);
//        for (int i = 0; i < meetings.length; i++) {
//            priorityQueue.add(meetings[i]);
//        }
//        System.out.println(priorityQueue.peek());

//        CuttingGoldBars cuttingGoldBars = new CuttingGoldBars();
//        int[] arr = {1, 1, 1, 1, 1, 2, 3};
//        int cutting = cuttingGoldBars.cutting(arr);
//        System.out.println(cutting);
        AndLookIntoTheCollection andLookIntoTheCollection = new AndLookIntoTheCollection();
        SampleNode node = new SampleNode(0);
        SampleNode node1 = new SampleNode(1);
        SampleNode node2 = new SampleNode(2);
        SampleNode node3 = new SampleNode(3);
        SampleNode node4 = new SampleNode(4);
        SampleNode node5 = new SampleNode(5);
        andLookIntoTheCollection.add(node);
        andLookIntoTheCollection.add(node1);
        andLookIntoTheCollection.add(node2);
        andLookIntoTheCollection.add(node3);
        andLookIntoTheCollection.add(node4);
        andLookIntoTheCollection.add(node5);

        andLookIntoTheCollection.mergeSet(node2,node1);
        andLookIntoTheCollection.mergeSet(node2,node3);
        andLookIntoTheCollection.mergeSet(node2,node5);
        andLookIntoTheCollection.print();
    }
}
