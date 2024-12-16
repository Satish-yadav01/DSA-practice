package dsalgo.datastructure.graph;

public class MyGraphExample {
    public static void main(String[] args) {
        int v = 4;
        MyGraph2 g = new MyGraph2(v);
        g.createGraph();

        int[] neighbour = g.neighbour(2);
        for (int j : neighbour) {
            System.out.print(j + " ");

        }
    }
}
