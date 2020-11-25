package cn.xqc.graph;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 拓扑排序：
 * 在有向图中，安排图中节点顺序
 */
public class TopologicalSorting {
    public void sort(GraphNode[] nodes) {
        HashSet<GraphNode> hashSet = new HashSet<>();
        while (hashSet.size() != nodes.length) {
            for (GraphNode node : nodes) {
                if (node.in == 0 && !hashSet.contains(node)) {
                    hashSet.add(node);
                    System.out.println(node);
                    ArrayList<GraphNode> nextNodes = node.nextNodes;
                    for (GraphNode graphNode : nextNodes){
                        graphNode.in--;
                    }
                }
            }
        }
    }
}
