package cn.xqc.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小生成树算法：K  P
 */
public class MinimumSpanningTree {
    /**
     * 最小生成树K算法
     * 将图中的节点，作为一个个集合，放入并查集中
     * 找出图中开销最小的路径，将其两端连接的点，合并为同一个集合，如果这两个点本身就是同一集合，不合并
     *
     * @param graph
     * @return
     */
    public ArrayList<Edge> kruskal(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
        BingChaJi<GraphNode> bingChaJ = new BingChaJi<>();
        ArrayList<Edge> edges = graph.edges;
        ArrayList<GraphNode> nodes = graph.nodes;
        for (Edge edge : edges) {
            priorityQueue.add(edge);
        }
        for (GraphNode node : nodes) {
            bingChaJ.add(node);
        }

        ArrayList<Edge> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            Edge poll = priorityQueue.poll();
            System.out.println(poll);

            GraphNode from = poll.from;
            GraphNode to = poll.to;
            if (!bingChaJ.isSameSet(from,to)){
                result.add(poll);
                bingChaJ.union(from,to);
            }
        }
        return result;
    }
}
