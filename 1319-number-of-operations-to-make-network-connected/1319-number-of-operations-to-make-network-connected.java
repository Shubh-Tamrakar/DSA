class Solution {
    
    public int makeConnected(int n, int[][] connections) {

        // Minimum n-1 cables are required
        if (connections.length < n - 1) {
            return -1;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Create graph
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Count connected components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        return components - 1;
    }

    public void dfs(int node,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }
}