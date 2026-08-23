class Solution {

    int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent, parent[x]);
    }

    boolean union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a == b)
            return false;

        parent[b] = a;
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int[] alice = new int[n + 1];
        int[] bob = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            alice[i] = i;
            bob[i] = i;
        }

        int used = 0;

        // Type 3 -> Alice + Bob
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean a = union(alice, e[1], e[2]);
                boolean b = union(bob, e[1], e[2]);

                if (a || b) {
                    used++;
                }
            }
        }

        // Type 1 -> Alice
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (union(alice, e[1], e[2])) {
                    used++;
                }
            }
        }

        // Type 2 -> Bob
        for (int[] e : edges) {
            if (e[0] == 2) {
                if (union(bob, e[1], e[2])) {
                    used++;
                }
            }
        }

        // Check Alice
        for (int i = 2; i <= n; i++) {
            if (find(alice, i) != find(alice, 1))
                return -1;
        }

        // Check Bob
        for (int i = 2; i <= n; i++) {
            if (find(bob, i) != find(bob, 1))
                return -1;
        }

        return edges.length - used;
    }
}