import java.util.*;

class Solution {

    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];

            // Outdated entry
            if (d > dist[node]) {
                continue;
            }

            for (int[] neighbour : adj.get(node)) {

                int nextNode = neighbour[0];
                int weight = neighbour[1];

                int newDist = d + weight;

                if (newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;

                    pq.add(new int[]{
                        newDist,
                        nextNode
                    });
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int d : dist) {
            ans.add(d);
        }

        return ans;
    }
}


