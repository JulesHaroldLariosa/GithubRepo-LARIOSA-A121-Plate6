import java.util.*;

// Task 2
public class AdjacencyMatrixGraphTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int[][] adjacencyMatrix = new int[V][V];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // Map to store the edges and their counts
        Map<String, Integer> edgeCountMap = new HashMap<>();

        // Loop through the adjacency matrix to find edges
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) { // Only consider the upper triangle to avoid duplicates
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + " - " + j;
                    edgeCountMap.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times.");
        }
    }
}
