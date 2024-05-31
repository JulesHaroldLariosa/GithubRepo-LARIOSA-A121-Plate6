import java.util.Scanner;

// Task 6
public class AdjacencyMatrixGraphTask6 {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public AdjacencyMatrixGraphTask6(int vertices) {
        this.numVertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination]++;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
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

        AdjacencyMatrixGraphTask6 graph = new AdjacencyMatrixGraphTask6(vertices);

        System.out.println("Enter the edges (source destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        scanner.close();

        graph.printAdjacencyMatrix();
    }
}