class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 4];
            buildTree(nums, 0, 0, n - 1);
        }
    }

    private void buildTree(int[] nums, int treeIndex, int lo, int hi) {
        if (lo == hi) {
            tree[treeIndex] = nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        buildTree(nums, 2 * treeIndex + 1, lo, mid);
        buildTree(nums, 2 * treeIndex + 2, mid + 1, hi);
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }

    private void updateTree(int treeIndex, int lo, int hi, int index, int val) {
        if (lo == hi) {
            tree[treeIndex] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (index <= mid) {
            updateTree(2 * treeIndex + 1, lo, mid, index, val);
        } else {
            updateTree(2 * treeIndex + 2, mid + 1, hi, index, val);
        }
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public int sumRange(int left, int right) {
        return queryTree(0, 0, n - 1, left, right);
    }

    private int queryTree(int treeIndex, int lo, int hi, int i, int j) {
        // If the segment is completely outside the query range
        if (lo > j || hi < i) {
            return 0;
        }
        // If the segment is completely inside the query range
        if (lo >= i && hi <= j) {
            return tree[treeIndex];
        }
        // Otherwise, partially overlaps
        int mid = lo + (hi - lo) / 2;
        return queryTree(2 * treeIndex + 1, lo, mid, i, j) + 
               queryTree(2 * treeIndex + 2, mid + 1, hi, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */