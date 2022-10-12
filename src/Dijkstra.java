import java.util.*;

public class Dijkstra {
    // Using https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
    // This priority queue represents Q in the algorithm and prioritizes nodes based on their lowest adjacent edge
    PriorityQueue<Node> nodesToDiscover = new PriorityQueue<Node>(new DistanceComparator());
    ArrayList<Node> addedNodes = new ArrayList<Node>();
    ArrayList<Node> knownNodes = new ArrayList<Node>();
    ArrayList<Node> unknownNodes = new ArrayList<Node>();


    Dijkstra(){}

    /**
     * Implementation of Dijkstra's shortest-path algorithm
     */
    void shortestPath(ArrayList<Node> graph, int startNodeIndex) {



        unknownNodes.addAll(graph); // used to know when to stop while loop



        graph.get(startNodeIndex).distance = 0;
        changeKey(nodesToDiscover, graph.get(startNodeIndex), 0);

        // Variables initialized to be used in while loop
        Node currentNode;
        Node nextNode;
        int edgeWeight;


        while(!unknownNodes.isEmpty()) {
            currentNode = ExtractMin(nodesToDiscover);
            knownNodes.add(currentNode); // known nodes are nodes for which the shortest path is know
            unknownNodes.remove(currentNode);

            System.out.println(currentNode);

            // Looks through all edges of current node
            for (int i = 0; i < currentNode.adjacentEdges.size(); i++) {
                nextNode = currentNode.adjacentEdges.get(i).destination;

                // Only looks at edges connecting to unknown node
                if (!knownNodes.contains(nextNode)) {
                    edgeWeight = currentNode.adjacentEdges.get(i).weight;

                    // If a shorter path is found
                    if (currentNode.distance + edgeWeight < nextNode.distance) {
                        // Updates nodes shortest path and predecessor
                        nextNode.distance = currentNode.distance + edgeWeight;
                        nextNode.shortestPathPredecessor = currentNode;

                        changeKey(nodesToDiscover, nextNode, nextNode.distance);
                    }
                }
            }
        }
    }

    /**
     * Takes smallest value from priority queue
     */
    Node ExtractMin(PriorityQueue<Node> Q) {
        Node toReturn = null;
        boolean searchingForNode = true;
        while (searchingForNode) {
            toReturn = Q.poll();
            if (!knownNodes.contains(toReturn)) {
                searchingForNode = false;
            }
        }
        return toReturn;
    }

    void changeKey(PriorityQueue<Node> Q, Node w, int distance) {
        nodesToDiscover.add(w);
        addedNodes.add(w);
    }


     void generateGraph(ArrayList<Node> graph) {
        // For the purposes of this list, node t is at index 0 and node s is at index 1
         Node t = new Node(0);
         Node s = new Node(1);
         Node two = new Node(2);
         Node three = new Node(3);
         Node four = new Node(4);
         Node five = new Node(5);
         Node six = new Node(6);
         Node seven = new Node(7);
        graph.add(0, t); // Node T
        graph.add(1, s); // Node T
        graph.add(2, two); // Node T
        graph.add(3, three); // Node T
        graph.add(4, four); // Node T
        graph.add(5, five); // Node T
        graph.add(6, six); // Node T
        graph.add(7, seven); // Node T

         s.addAdjacentEdge(new Edge(s,two,9));
         s.addAdjacentEdge(new Edge(s,six,14));
         s.addAdjacentEdge(new Edge(s,seven,15));

         two.addAdjacentEdge(new Edge(two,three,23));

         three.addAdjacentEdge(new Edge(three,t,19));
         three.addAdjacentEdge(new Edge(three,five,2));

         four.addAdjacentEdge(new Edge(four,three,6));
         four.addAdjacentEdge(new Edge(four,t,6));

         five.addAdjacentEdge(new Edge(five,four,11));
         five.addAdjacentEdge(new Edge(five,t,16));

         six.addAdjacentEdge(new Edge(six,three,18));
         six.addAdjacentEdge(new Edge(six,five,30));
         six.addAdjacentEdge(new Edge(six,seven,5));

         seven.addAdjacentEdge(new Edge(seven,five,20));
         seven.addAdjacentEdge(new Edge(seven,t,44));
     }

}


