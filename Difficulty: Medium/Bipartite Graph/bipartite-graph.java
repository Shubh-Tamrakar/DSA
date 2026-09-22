class Solution {
    public boolean isBipartite(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[V];

        TreeSet<Integer> red = new TreeSet<>();
        TreeSet<Integer> green = new TreeSet<>();

        Queue<Integer> q = new LinkedList<>();

        for (int start = 0; start < V; start++) {

            if (visited[start])
                continue;

            q.add(start);
            red.add(start);

            while (!q.isEmpty()) {

                int node = q.remove();

                if (visited[node])
                    continue;

                for (int neigh : adj.get(node)) {

                    // node red hai → neighbour green hona chahiye
                    if (red.contains(node)) {

                        if (red.contains(neigh))
                            return false;

                        green.add(neigh);
                    }

                    // node green hai → neighbour red hona chahiye
                    else {

                        if (green.contains(neigh))
                            return false;

                        red.add(neigh);
                    }

                    q.add(neigh);
                }

                visited[node] = true;
            }
        }

        return true;
    }
}