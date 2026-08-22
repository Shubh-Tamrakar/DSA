import java.util.*;

class Solution {

    public boolean isBridge(int V, int[][] edges, int c, int d) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        dfs(c, c, d, adj, visited);

        return !visited[d];
    }

    private void dfs(int node, int c, int d,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {

        visited[node] = true;

        for (int neigh : adj.get(node)) {

            // Only ignore the c -> d edge
            if (node == c && neigh == d) {
                continue;
            }

            if (!visited[neigh]) {
                dfs(neigh, c, d, adj, visited);
            }
        }
    }
}