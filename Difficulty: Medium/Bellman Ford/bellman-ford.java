class Solution {

    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];

        Arrays.fill(dist, 100000000);

        dist[src] = 0;

  
        for (int i = 1; i <= V - 1; i++) {

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != 100000000 &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

   
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != 100000000 &&
                dist[u] + wt < dist[v]) {

                ArrayList<Integer> list = new ArrayList<>();
                list.add(-1);
                return list;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(dist[i]);
        }

        return list;
    }
}