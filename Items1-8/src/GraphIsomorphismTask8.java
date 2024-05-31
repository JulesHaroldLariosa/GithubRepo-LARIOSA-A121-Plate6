import java.util.Scanner;

// Task 8
public class GraphIsomorphismTask8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in both graphs: ");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] graph1 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] graph2 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        if (areGraphsIsomorphic(graph1, graph2, numVertices)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }
    }

    private static boolean areGraphsIsomorphic(int[][] graph1, int[][] graph2, int numVertices) {
        int[] mapping = new int[numVertices];
        boolean[] used = new boolean[numVertices];
        return checkIsomorphism(graph1, graph2, mapping, used, 0, numVertices);
    }

    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] mapping, boolean[] used, int pos, int numVertices) {
        if (pos == numVertices) {
            return verifyMapping(graph1, graph2, mapping, numVertices);
        }

        for (int i = 0; i < numVertices; i++) {
            if (!used[i]) {
                used[i] = true;
                mapping[pos] = i;
                if (checkIsomorphism(graph1, graph2, mapping, used, pos + 1, numVertices)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }

    private static boolean verifyMapping(int[][] graph1, int[][] graph2, int[] mapping, int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (graph1[i][j] != graph2[mapping[i]][mapping[j]]) {
                    return false;
                }
            }
        }
        return true;
    }
}
