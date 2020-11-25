package cn.xqc.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
//        Person[] generate = Person.generate(10);
//        for (Person person : generate){
//            System.out.println(person);
//        }
//        SameAccount account = new SameAccount();
//        int i = account.same2(generate);
//        int same = account.same(generate);
//        System.out.println(i);
//        System.out.println(same);
//        GraphNode node = new GraphNode(1);
//        GraphNode node1 = new GraphNode(1);
//
//        ArrayList<GraphNode> list = new ArrayList<>();
//        list.add(node);
//        System.out.println(list.contains(node1));
        int[][] matrix = {
                {0, -1, 2, -1},
                {1, 0, -1, 4},
                {2, 5, 0, -1},
                {1, 3, 0, 0}
        };
        AdjacencyMatrixToGraph toGraph = new AdjacencyMatrixToGraph();
        Graph graph = toGraph.matrixTo(matrix);
//        System.out.println(graph);
//        System.out.println();
//
//        Traversing traversing = new Traversing();
//        traversing.widthTraversing(graph.nodes.get(1));
//        System.out.println();
//        traversing.depthTraversing(graph.nodes.get(3));
//        System.out.println();
//        traversing.depth(graph.nodes.get(3));
//        System.out.println();

        MinimumSpanningTree spanningTree = new MinimumSpanningTree();
        System.out.println(spanningTree.kruskal(graph));
    }
}
