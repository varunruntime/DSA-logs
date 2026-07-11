import java.util.*;

class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    int vertices;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];

        int completeComponents = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                vertices = 0;
                degreeSum = 0;

                dfs(i);

                int actualEdges = degreeSum / 2;
                int requiredEdges = vertices * (vertices - 1) / 2;

                if (actualEdges == requiredEdges) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node) {

        visited[node] = true;
        vertices++;

        degreeSum += graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}