class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[V];

        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);

            adj.get(u).add(new int[]{v, w});
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] e : adj.get(u)) {
                int v = e[0];
                int w = e[1];

                if (dist[u] != Integer.MIN_VALUE) {
                    dist[v] = Math.max(dist[v], dist[u] + w);
                }

                indegree[v]--;

                if (indegree[v] == 0)
                    q.add(v);
            }
        }

        return dist;
    }
}