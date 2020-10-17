package cn.xqc.data_structure;

import java.util.Stack;

/**
 * 使用两个栈模拟队列
 * stack1 为输入栈，将数据添加到 stack1 中，然后 stack1 出栈到 stack2 ，stack2 输出
 */
public class StackSimulateQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public StackSimulateQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int value){
        //this.rotato();
        stack1.push(value);
    }
    public int pop(){
        this.rotato();
        Integer pop = stack2.pop();
        return pop;
    }
//    public void print(){
//
//    }

    //若stack2为空，则将stack1中的数出栈到stack2中
    public void rotato() {
        if (stack2.empty() && !stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}
