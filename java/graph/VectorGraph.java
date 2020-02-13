package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shmilyiselephant
 * @date 12.02.20
 * @decription
 */
public class VectorGraph {
    private int v;
    private LinkedList<Integer> adj[];

    public VectorGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        adj[start-1].add(end);
    }

    public void printGraph() {
        for (LinkedList<Integer> row: adj)
            System.out.println(row);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s)
            print(prev, s, prev[t]);
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        VectorGraph aGraph = new VectorGraph(5);
        aGraph.addEdge(1,2);
        aGraph.addEdge(3,4);
        aGraph.addEdge(4,2);
        aGraph.addEdge(4,1);
        aGraph.addEdge(4,3);
        aGraph.addEdge(3,5);
        aGraph.printGraph();
    }
}
