import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Defines the structure of an edge.
class Edge {
	int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

// Defines the structure of a subset element.
class Subset {
	int parent, rank;
}

class A7 {
	int V;
	List<Edge> edges;

	// Constructor for initializing the number of vertices and the list of edges.
	A7(int V, List<Edge> edges) {
		this.V = V;
		this.edges = edges;
	}

	// Kruskal's algorithm to find the Minimum Spanning Tree (MST).
	void kruskals() {
		// I create a list to store the edges of the Minimum Spanning Tree (MST).
		List<Edge> result = new ArrayList<>();

		// I sort the edges in ascending order based on their weights using the Collections.sort() method
		// and the Comparator.comparingInt() method to compare the weights.
		Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

		// I create an array of subsets to keep track of disjoint sets.
		Subset[] subsets = new Subset[V];
		for (int i = 0; i < V; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		// Variables to keep track of the current edge and the number of edges in the result MST.
		int edgeIndex = 0;
		int resultIndex = 0;

		// Iterate through the sorted edges.
		while (resultIndex < V - 1) {
			// Get the next edge with the smallest weight.
			Edge nextEdge = edges.get(edgeIndex++);

			// Find the root/parent of the sets that the source and destination vertices belong to.
			int x = findRoot(subsets, nextEdge.src);
			int y = findRoot(subsets, nextEdge.dest);

			// If including this edge does not create a cycle, add it to the result MST.
			if (x != y) {
				result.add(nextEdge);
				// Union the two sets by rank.
				union(subsets, x, y);
				resultIndex++;
			}
		}

		// Print the Minimum Spanning Tree.
		System.out.println("Minimum Spanning Tree:");
		for (Edge edge : result) {
			System.out.println(edge.src + " - " + edge.dest + " == " + edge.weight);
		}
	}

	// Function to find the root/parent of a set using the path compression technique.
	int findRoot(Subset[] subsets, int i) {
		// If the parent of the subset is not itself, recursively find the root and update the parent.
		if (subsets[i].parent != i) {
			subsets[i].parent = findRoot(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}

	// Function to unite two disjoint sets by rank.
	void union(Subset[] subsets, int x, int y) {
		int xRoot = findRoot(subsets, x);
		int yRoot = findRoot(subsets, y);

		// Attach the set with a smaller rank to the set with a higher rank.
		if (subsets[xRoot].rank < subsets[yRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else if (subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else {
			// If the ranks are equal, attach one set to the other and increment the rank.
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}

	public static void main(String[] args) {
	    // I create a graph with 6 vertices and 9 edges.
	    int V = 6;
	    List<Edge> edges = new ArrayList<>();
	    edges.add(new Edge(0, 1, 4));
	    edges.add(new Edge(0, 2, 3));
	    edges.add(new Edge(1, 2, 1));
	    edges.add(new Edge(1, 3, 2));
	    edges.add(new Edge(2, 3, 4));
	    edges.add(new Edge(2, 4, 3));
	    edges.add(new Edge(3, 4, 2));
	    edges.add(new Edge(3, 5, 1));
	    edges.add(new Edge(4, 5, 5));

	    // I create an instance of the A7 class and find the Minimum Spanning Tree.
	    A7 mst = new A7(V, edges);
	    mst.kruskals();
	}
}
