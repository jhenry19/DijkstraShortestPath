import java.util.Comparator;

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