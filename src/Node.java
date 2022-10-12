import java.util.ArrayList;

public class Node implements Cloneable{
	int index;
	int distance = Integer.MAX_VALUE;
	ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
	// A placeholder edge not in the graph with an infinite weight. This will only be returned if the node had no adjacent edges
	Edge lowestEdge;
	Node shortestPathPredecessor;

	Node(int i) {
		index = i;
	}

	void addAdjacentEdge(Edge e) {
		adjacentEdges.add(e);
		lowestEdge = getLowestAdjacentEdge();
	}

	Edge getLowestAdjacentEdge() {
		int lowestWeight = Integer.MAX_VALUE;
		Edge toReturn = lowestEdge;
		for(int i = 0; i < adjacentEdges.size(); i++) {
			if (adjacentEdges.get(i).weight < lowestWeight) {
				toReturn = adjacentEdges.get(i);
				lowestWeight = adjacentEdges.get(i).weight;
			}
		}
		return toReturn;
	}

	String tracePath(Node n) {
		if (n.index == 1) {
			return "1";
		}
		else {
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
