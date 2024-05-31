import java.util.*;

// Task 4
public class DegreeOfVertexTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        int[] degree = new int[V];

        System.out.println("Enter the edges: ");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degree[u]++;
            degree[v]++;
        }

        scanner.close();

        for (int i = 0; i < V; i++) {
            System.out.println("Degree of vertex " + i + " is " + degree[i]);
        }
    }
}