package cn.xqc.avarice;

import java.util.PriorityQueue;

/**
 * 切金条问题：
 * 给一个数组，数组中的数就是最后要切成的结果，数组之和就是金条长度
 * 每切割一次金条，就要花费与切割金条长度相同的钱，要求使用最少的钱，完成切割
 * 使用哈夫曼树：构造一个小根堆，拿出其中最小的两个数，相加后放回，循环，直到堆中只有一个数
 * 此时，拿出来的所有数之和，就是最优的结果
 */
public class CuttingGoldBars {
    public int cutting(int[] arr) {
        int money = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((m1, m2) -> m1 - m2);
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        while (priorityQueue.size() != 1) {
            Integer poll = priorityQueue.poll();
            Integer poll1 = priorityQueue.poll();
            money = money + poll + poll1;
            priorityQueue.add(poll + poll1);
        }
        return money;
    }
}
