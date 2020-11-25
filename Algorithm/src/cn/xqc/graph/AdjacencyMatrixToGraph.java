package cn.xqc.graph;

/**
 * 将邻接矩阵转换为图
 */
public class AdjacencyMatrixToGraph {
    public Graph matrixTo(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                GraphNode node = new GraphNode(j);
                if (!graph.nodes.contains(node))
                    graph.nodes.add(node);
                if (matrix[i][j] > 0){
                    GraphNode node1 = graph.nodes.get(i);
                    GraphNode node2 = graph.nodes.get(j);
                    Edge edge = new Edge(matrix[i][j], node1, node2);

                    graph.edges.add(edge);
                    node1.out++;
                    node1.nextNodes.add(node2);
                    node1.nextEdges.add(edge);
                    node2.in++;
                }
            }
        }
        return graph;
    }
}
