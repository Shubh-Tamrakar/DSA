import java.util.*;

class Solution {
    private List<Integer>[] origTree;
    private List<Integer>[] newTree;
    private int[] newParent;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.origTree = new ArrayList[n];
        this.newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        this.newParent = Arrays.copyOf(parent, n);
        this.lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        // Step 1: Find the closest ancestor with the same character for every node
        findNewParents(0);

        // Step 2: Build the final tree from newParent
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Step 3: Compute subtree sizes in the final tree
        this.ans = new int[n];
        computeSubtreeSize(0);
        return ans;
    }

    private void findNewParents(int u) {
        int c = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[c];

        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        lastSeen[c] = u;
        for (int v : origTree[u]) {
            findNewParents(v);
        }
        lastSeen[c] = prevAncestor;
    }

    private int computeSubtreeSize(int u) {
        int size = 1;
        for (int v : newTree[u]) {
            size += computeSubtreeSize(v);
        }
        ans[u] = size;
        return size;
    }
}