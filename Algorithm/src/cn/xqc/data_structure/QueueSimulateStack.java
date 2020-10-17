package cn.xqc.data_structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用两个队列来模拟栈，设置两个队列分别是 src dest
 * src 为源队列，dest为目的队列，向模拟栈中添加元素时，src增加
 * 取出元素时，假设src有n个元素，src出队列的（n-1）个元素进入dest，最后一个元素出模拟栈，src和dest互换
 */
public class QueueSimulateStack {
    Queue<Integer> source;
    Queue<Integer> destination;
    public QueueSimulateStack(){
        source = new LinkedBlockingQueue<>();
        destination = new LinkedBlockingQueue<>();
    }

    public void push(int value){
        source.add(value);
    }
    public int pop(){
        int result;
        if (source.size() == 0)
            throw new RuntimeException("栈为空");
        while (source.size() > 1){
            destination.add(source.remove());
        }
        result = source.remove();
        //source和destination互换
        Queue<Integer> temp = source;
        source = destination;
        destination = temp;

        return result;
    }
}
