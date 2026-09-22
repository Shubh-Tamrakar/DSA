class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1 % k;
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // update nums[index]
            update(1, 0, n - 1, index, value);

            // query [start, n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {

        tree[node] = new Node(k);

        if (l == r) {

            int rem = nums[l] % k;

            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node);
    }

    void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            int rem = value % k;

            tree[node].prod = rem;

            tree[node].cnt = new int[k];
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node);
    }

    void merge(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];

        tree[node].prod =
            (left.prod * right.prod) % k;

        tree[node].cnt = new int[k];

        // Prefixes completely inside left
        for (int rem = 0; rem < k; rem++) {
            tree[node].cnt[rem] += left.cnt[rem];
        }

        // Prefixes which cross left and enter right
        for (int rem = 0; rem < k; rem++) {

            int newRem = (left.prod * rem) % k;

            tree[node].cnt[newRem] += right.cnt[rem];
        }
    }

    Node query(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return combine(left, right);
    }

    Node combine(Node left, Node right) {

        Node res = new Node(k);

        res.prod = (left.prod * right.prod) % k;

        for (int rem = 0; rem < k; rem++) {
            res.cnt[rem] += left.cnt[rem];
        }

        for (int rem = 0; rem < k; rem++) {

            int newRem = (left.prod * rem) % k;

            res.cnt[newRem] += right.cnt[rem];
        }

        return res;
    }
}