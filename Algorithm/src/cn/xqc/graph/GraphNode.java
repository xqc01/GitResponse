package cn.xqc.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 */
public class GraphNode {
    public int in = 0;
    public int out = 0;
    public int value;
    public ArrayList<GraphNode> nextNodes = new ArrayList<>();
    public ArrayList<Edge> nextEdges = new ArrayList<>();

    public GraphNode() {
    }

    public GraphNode(int value) {
        this.value = value;
    }

    public GraphNode(int in, int out, int value, ArrayList<GraphNode> nextNodes, ArrayList<Edge> nextEdges) {
        this.in = in;
        this.out = out;
        this.value = value;
        this.nextNodes = nextNodes;
        this.nextEdges = nextEdges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;

        GraphNode node = (GraphNode) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "in=" + in +
                ", out=" + out +
                ", value=" + value +
                '}';
    }
}
