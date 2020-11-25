package cn.xqc.graph;

import java.util.ArrayList;

/**
 * 图
 */
public class Graph {
    public ArrayList<GraphNode> nodes = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();

    public Graph() {
    }

    public Graph(ArrayList<GraphNode> nodes, ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
