import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Graph disconnected bhi ho sakta hai
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node,
                        int parent,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            // Unvisited neighbour
            if (!visited[neighbour]) {

                if (dfs(neighbour, node, adj, visited)) {
                    return true;
                }
            }

            // Already visited and not parent
            else if (visited[neighbour] && neighbour != parent) {
                return true;
            }
        }

        return false;
    }
}