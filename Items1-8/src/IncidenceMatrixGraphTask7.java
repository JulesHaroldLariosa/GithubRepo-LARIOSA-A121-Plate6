import java.util.Scanner;

// Task 7
public class IncidenceMatrixGraphTask7 {
    private int[][] incidenceMatrix;
    private int numVertices;
    private int numEdges;

    // To initialize the incidence matrix
    public IncidenceMatrixGraphTask7(int vertices, int edges) {
        this.numVertices = vertices;
        this.numEdges = edges;
        this.incidenceMatrix = new int[vertices][edges];
    }

    // To add an edge to the incidence matrix
    public void addEdge(int edgeIndex, int vertex1, int vertex2, int count) {
        incidenceMatrix[vertex1][edgeIndex] = count;
        incidenceMatrix[vertex2][edgeIndex] = count;
    }

    public void printIncidenceMatrix() {
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        IncidenceMatrixGraphTask7 graph = new IncidenceMatrixGraphTask7(vertices, edges);

        System.out.println("Enter the edges with their counts (vertex1 vertex2 count): ");
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int count = scanner.nextInt();
            graph.addEdge(i, vertex1, vertex2, count);
        }

        scanner.close();

        graph.printIncidenceMatrix();
    }
}
