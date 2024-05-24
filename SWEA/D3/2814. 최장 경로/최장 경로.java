import java.util.*;
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // number of vertices
            int M = sc.nextInt(); // number of edges

            // Create an adjacency matrix to represent the graph
            int[][] graph = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u][v] = 1;
                graph[v][u] = 1;
            }

            int maxDepth = 0;
            for (int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N + 1];
                maxDepth = Math.max(maxDepth, dfs(graph, visited, i, 1));
            }

            System.out.println("#" + tc + " " + maxDepth);
        }

        sc.close();
    }

    private static int dfs(int[][] graph, boolean[] visited, int node, int depth) {
        visited[node] = true;
        int maxDepth = depth;

        for (int i = 1; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                maxDepth = Math.max(maxDepth, dfs(graph, visited, i, depth + 1));
            }
        }

        visited[node] = false;
        return maxDepth;
    }
}