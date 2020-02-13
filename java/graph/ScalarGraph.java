package graph;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * @author shmilyiselephant
 * @date 12.02.20
 * @decription
 */
public class ScalarGraph {
    private int v;
    private LinkedList<Integer> adj[];

    public ScalarGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
            for (int j = 0; j < v; j++)
                adj[i].add(0);
        }
    }

    public void addEdge(int s, int t) {
        adj[s-1].set(t-1, 1);
        adj[t-1].set(s-1, 1);
    }

    public void printGraph() {
        for (LinkedList<Integer> row: adj)
            System.out.println(row);
    }

    public static void main(String[] args) {
        ScalarGraph aGraph = new ScalarGraph(5);
        aGraph.addEdge(3,2);
        aGraph.addEdge(4,2);
        aGraph.addEdge(5,4);
        aGraph.addEdge(3,1);
        aGraph.printGraph();
    }

}
