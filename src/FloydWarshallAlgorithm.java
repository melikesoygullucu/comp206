public class FloydWarshallAlgorithm {
    final static int INF = 99999;

    // Function to apply the Floyd-Warshall algorithm
    static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the distance matrix with the graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Applying Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distances
        printSolution(dist);
    }

    // Function to print the shortest distances
    static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between all pairs of vertices:");

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Main function to test the Floyd-Warshall Algorithm 
    public static void main(String[] args) {
        int[][] graph1 = {
            {0, INF, -2, INF},
            {4, 0, 3, INF},
            {INF, INF, 0, 2},
            {INF, -1, INF, 0}
        };

        floydWarshall(graph1);
    }
}
