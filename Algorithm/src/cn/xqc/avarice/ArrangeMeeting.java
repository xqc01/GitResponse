package cn.xqc.avarice;

import java.util.PriorityQueue;

/**
 * 安排会议问题：
 * 给定一个会议数组，每个会议对象包含开始时间和结束时间，要求一天内安排最多的会议
 * 贪心策略：按照会议结束时间安排
 */
public class ArrangeMeeting {
    public int arrange(Meeting[] meetings) {
        int max = 0;
        int curTime = 0;
        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>((m1, m2) -> m1.end - m2.end);
        for (int i = 0; i < meetings.length; i++) {
            priorityQueue.add(meetings[i]);
        }
        while (!priorityQueue.isEmpty()) {
            Meeting poll = priorityQueue.poll();
            if (poll.begin >= curTime) {
                max++;
                curTime = poll.end;
            }
        }
        return max;
    }
}

class Meeting {
    public int begin;
    public int end;

    public Meeting() {
    }

    public Meeting(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
