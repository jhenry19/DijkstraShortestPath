import java.util.ArrayList;

/**
 * Node class is an object used to hold information about each node in the graph
 */
public class Node implements Cloneable{
	int index; // a label used to identify each node
	int distance = Integer.MAX_VALUE; // set as a high number for use in dijkstra's algorithm
	ArrayList<Edge> adjacentEdges = new ArrayList<Edge>(); // all edges originating with this node
	Node shortestPathPredecessor; // this nodes predecessor on the shortest path found to it

	Node(int i) {
		index = i;
	}

	/**
	 * A recursive algorithm used in printing the shortest path to an algorithm once Dijkstra's has found it
	 */
	String tracePath(Node n) {
		if (n.index == 1) { // Base case of being node S
			return "1";
		}
		else { // Recursive case
			return tracePath(n.shortestPathPredecessor) + "-" + n.index;
		}

	}

	@Override
	public String toString() {
		String toReturn = "Node " + index + " included in S. Distance: " + distance + ". Shortest path: " + tracePath(this);
		toReturn = toReturn.replace('0','T');
		toReturn = toReturn.replace('1','S');

		return toReturn;

	}
}
