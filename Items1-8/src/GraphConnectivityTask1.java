import java.util.*;

// Task 1
public class GraphConnectivityTask1 {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    // Constructor
    GraphConnectivityTask1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Method to check if all vertices are connected
    boolean isConnected() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Find a vertex with non-zero degree
        int i;
        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0) {
                break;
            }
        }

        // If there are no edges in the graph, return true
        if (i == V) {
            return true;
        }

        // Start DFS from a vertex with non-zero degree
        DFSUtil(i, visited);

        // Check if all non-zero degree vertices are visited
        for (i = 0; i < V; i++) {
            if (adj[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Method to find the number of connected components
    int countConnectedComponents() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int count = 0;

        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        GraphConnectivityTask1 g = new GraphConnectivityTask1(V);

        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < E; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u, v);
        }

        scanner.close();

        if (g.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int components = g.countConnectedComponents();
            System.out.println("Number of connected components: " + components);
        }
    }
}