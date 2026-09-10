class Solution {

    int count = 0;

    public int averageOfSubtree(TreeNode root) {

        if (root == null) return 0;

        int sum = sum(root);
        int num = nodes(root);

        int avg = sum / num;

        if (avg == root.val) {
            count++;
        }

        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return count;
    }

    public int sum(TreeNode root) {

        if (root == null) return 0;

        return root.val + sum(root.left) + sum(root.right);
    }

    public int nodes(TreeNode root) {

        if (root == null) return 0;

        return 1 + nodes(root.left) + nodes(root.right);
    }
}