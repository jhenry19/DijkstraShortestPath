import java.util.ArrayList;

/**
 * Node class is an object used to hold information about each node in the graph
 */
public class Node implements Cloneable{
	int index; // an identifier for each node
	int distance = Integer.MAX_VALUE; // a large number is initiated here for use by Dijkstra's
	ArrayList<Edge> adjacentEdges = new ArrayList<Edge>(); // All edges with this node as origin
	Node shortestPathPredecessor; // The node previous this on the shortest path found

	Node(int i) {
		index = i;
	}

	void addAdjacentEdge(Edge e) {
		adjacentEdges.add(e);
	}


	/**
	 * A recursive algorithm used in printing the shortest path to an algorithm once Dijkstra's has found it
	 */
	String tracePath(Node n) {
		if (n.index == 1) { // Base case of the node being S
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
