import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        int[] visited = new int[V];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        // Directed graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
        }

        for (int i = 0; i < V; i++) {

            if (visited[i] == 0) {

                if (dfs(i, list, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> list,
                        int[] visited) {

        // Currently in DFS path
        visited[node] = 1;

        for (int neighbour : list.get(node)) {

            // Node current DFS path mein already hai
            if (visited[neighbour] == 1) {
                return true;
            }

            // Not visited
            if (visited[neighbour] == 0) {

                if (dfs(neighbour, list, visited)) {
                    return true;
                }
            }
        }

        // DFS completely finished
    visited[node] = 2;

        return false;
    }
}