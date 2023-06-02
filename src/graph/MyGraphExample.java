package graph;

import java.util.ArrayList;

public class MyGraphExample {
    public static void main(String[] args) {
        int v = 4;
//        ArrayList<MyGraph.Edge> graph[] = new ArrayList[v];
        MyGraph g = new MyGraph(v);
        g.createGraph();

        int[] neighbour = g.neighbour(2);
        for (int i = 0; i < neighbour.length; i++) {
            System.out.print(neighbour[i]+" ");

        }
    }
}
