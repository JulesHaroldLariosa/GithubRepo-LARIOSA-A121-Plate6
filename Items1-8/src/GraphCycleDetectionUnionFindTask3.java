import java.util.*;

// Task 3
public class GraphCycleDetectionUnionFindTask3 {
    private int V;
    private List<Edge> edges;

    class Edge {
        int src, dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public GraphCycleDetectionUnionFindTask3(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    boolean isCyclic() {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x == y)
                return true;

            union(parent, x, y);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        GraphCycleDetectionUnionFindTask3 graph = new GraphCycleDetectionUnionFindTask3(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges: ");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        scanner.close();

        if (graph.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}