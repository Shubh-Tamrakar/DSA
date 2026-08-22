import java.util.*;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<Integer> list = new ArrayList<>();

        // Adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Create graph
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean visited[] = new boolean[V];

        // DFS for every component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, list);
            }
        }

        // Reverse because DFS gives reverse topological order
        Collections.reverse(list);

        return list;
    }

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean visited[],
                     ArrayList<Integer> list) {

        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, list);
            }
        }

        // Node ko tab add karenge jab uske saare neighbours visit ho chuke hain
        list.add(node);
    }
}