class Solution {
    static class Node {
        int len, left, right, best;
        char lc, rc;

        Node(int len, char c) {
            this.len = len;
            this.left = this.right = this.best = 1;
            this.lc = this.rc = c;
        }
    }

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node(a.len + b.len, a.lc);

        res.lc = a.lc;
        res.rc = b.rc;

        res.left = a.left;
        if (a.left == a.len && a.rc == b.lc)
            res.left = a.len + b.left;

        res.right = b.right;
        if (b.right == b.len && a.rc == b.lc)
            res.right = b.len + a.right;

        res.best = Math.max(a.best, b.best);

        if (a.rc == b.lc)
            res.best = Math.max(res.best, a.right + b.left);

        return res;
    }

    Node[] tree;

    void build(char[] s, int idx, int l, int r) {
        if (l == r) {
            tree[idx] = new Node(1, s[l]);
            return;
        }

        int mid = (l + r) / 2;
        build(s, idx * 2, l, mid);
        build(s, idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            tree[idx] = new Node(1, c);
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(idx * 2, l, mid, pos, c);
        else
            update(idx * 2 + 1, mid + 1, r, pos, c);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        char[] arr = s.toCharArray();

        tree = new Node[4 * n];
        build(arr, 1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int pos = queryIndices[i];
            arr[pos] = queryCharacters.charAt(i);

            update(1, 0, n - 1, pos, arr[pos]);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}