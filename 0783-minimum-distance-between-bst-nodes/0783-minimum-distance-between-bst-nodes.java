/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {

        help(root);

        return ans;
    }

    private void help(TreeNode root) {

        if (root == null)
            return;

        help(root.left);

        if (prev != null)
            ans = Math.min(ans, root.val - prev.val);

        prev = root;

        help(root.right);
    }
}