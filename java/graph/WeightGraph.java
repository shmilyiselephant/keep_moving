package graph;

import java.util.LinkedList;

/**
 * @author shmilyiselephant
 * @date 12.02.20
 * @decription
 */
public class WeightGraph {
    private int v;
    private LinkedList<Integer> adj[];

    public WeightGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            for (int j = 0; j < v; j++)
                adj[i].add(0);
        }
    }

    public void addEdge(int start, int end, int weight) {
        adj[start-1].set(end-1, weight);
    }

    public void printGraph() {
        for (LinkedList<Integer> row: adj)
            System.out.println(row);
    }

    public static void main(String[] args) {
        WeightGraph aGraph = new WeightGraph(5);
        aGraph.addEdge(3,5,6);
        aGraph.printGraph();
    }
}
