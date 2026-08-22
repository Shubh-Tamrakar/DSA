import java.util.*;

class Solution {

   

    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // node 0 se start
        pq.add(new int[]{0,0});

        int sum = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int weight = curr[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            sum += weight;

            for (int[] neigh : adj.get(node)) {

                if (!visited[neigh[0]]) {
                    pq.add(new int[]{neigh[0], neigh[1]});
                }
            }
        }

        return sum;
    }
}
