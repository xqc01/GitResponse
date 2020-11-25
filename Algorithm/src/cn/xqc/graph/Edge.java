package cn.xqc.graph;

/**
 * 边：属性有权重
 */
public class Edge {
    public int value;
    public GraphNode from = null;
    public GraphNode to = null;

    public Edge() {
    }

    public Edge(int value) {
        this.value = value;
    }

    public Edge(int value, GraphNode from, GraphNode to) {
        this.value = value;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "value=" + value +
                ", from=" + from.value +
                ", to=" + to.value +
                '}';
    }
}
