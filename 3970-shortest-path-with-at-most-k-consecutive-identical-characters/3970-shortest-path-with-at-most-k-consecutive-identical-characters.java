import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of (v, weight)
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w});
        }

        // Min-heap storing {accumulated_weight, u, count}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // dist[u][count] stores the minimum weight to reach node u with a given consecutive count
        // Since count can range from 1 to k, we use size k + 1.
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Base case: starting at node 0 with count 1
        pq.offer(new long[]{0, 0, 1});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long weight = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            // If we reached the destination node, return the weight
            if (u == n - 1) {
                return (int) weight;
            }

            // If this state has already been visited with a shorter path, skip
            if (weight > dist[u][count]) {
                continue;
            }

            // Explore neighbors
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];

                int nextCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // If the next consecutive count exceeds k, this path is invalid
                if (nextCount > k) {
                    continue;
                }

                // Relaxation step
                if (weight + w < dist[v][nextCount]) {
                    dist[v][nextCount] = weight + w;
                    pq.offer(new long[]{weight + w, v, nextCount});
                }
            }
        }

        // If node n - 1 is unreachable
        return -1;
    }
}