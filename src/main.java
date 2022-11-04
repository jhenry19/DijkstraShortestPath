import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();

        // Create graph for this assignment
        ArrayList<Node> graph = new ArrayList<Node>();
        d.generateGraph(graph);

        System.out.println("The graph is represented by a list containing node objects. " +
                "This format most closely resembles an adjacency list.");

        //Dijkstra's is run with S as the start node
        d.shortestPath(graph, 1);

    }
}
