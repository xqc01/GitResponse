package cn.xqc.graph;

import sun.security.provider.PolicyParser;

import java.util.*;

/**
 * 宽度优先遍历，深度优先遍历
 */
public class Traversing {
    /**
     * 宽度优先遍历，使用队列
     * @param head
     */
    public void widthTraversing(GraphNode head){
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> hashSet = new HashSet<>();
        hashSet.add(head);
        queue.add(head);
        while (!queue.isEmpty()){
            GraphNode poll = queue.poll();
            System.out.println(poll);
            ArrayList<GraphNode> nextNodes = poll.nextNodes;
            for (GraphNode node : nextNodes){
                if (!hashSet.contains(node)){
                    hashSet.add(node);
                    queue.add(node);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * @param head
     */
    public void depthTraversing(GraphNode head){
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> hashSet = new HashSet<>();
        stack.add(head);
        System.out.println(head);
        hashSet.add(head);
        while (!stack.isEmpty()){
            GraphNode pop = stack.pop();
            ArrayList<GraphNode> nextNodes = pop.nextNodes;
            for (GraphNode node : nextNodes){
                if (!hashSet.contains(node)){
                    stack.add(pop);
                    stack.add(node);
                    System.out.println(node);
                    hashSet.add(node);
                    break;
                }
            }
        }
    }

    /**
     * 使用递归，完成深度优先遍历
     * @param head
     */
    public void depth(GraphNode head){
        HashSet<GraphNode> hashSet = new HashSet<>();
        depthProcess(head,hashSet);
    }
    public void depthProcess(GraphNode head, HashSet<GraphNode> hashSet){
        if (hashSet.contains(head))
            return;
        hashSet.add(head);
        System.out.println(head);
        ArrayList<GraphNode> nextNodes = head.nextNodes;
        for (GraphNode node : nextNodes){
            depthProcess(node,hashSet);
        }
    }
}
