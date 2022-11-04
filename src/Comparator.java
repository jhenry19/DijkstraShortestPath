import java.util.Comparator;

/**
 * This comparator is used for soring different distance nodes in the priority queue. With this, when
 * adding nodes to the queue, they are automatically sorted by distance
 */
class DistanceComparator implements Comparator<Node> {
// Adapted from https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
	// Overriding compare() method of Comparator
	public int compare(Node n1, Node n2) {
		if (n1.distance > n2.distance)
			return 1;
		else if (n1.distance < n2.distance)
			return -1;
		return 0;
	}
}