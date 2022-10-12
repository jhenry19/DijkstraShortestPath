public class Edge {
    int weight;
    Node source;
    Node destination;

    Edge(Node s, Node d, int w) {
        this.weight = w;
        this.source = s;
        this.destination = d;
    }

    @Override
    public String toString() {
        return source + " -> " + destination + ", " + weight;
    }
}
