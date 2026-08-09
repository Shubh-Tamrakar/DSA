/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    public ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        
        if (!isLeaf(root))
            ans.add(root.data);

      
        leftBoundary(root.left, ans);

        
        leaves(root, ans);

        
        rightBoundary(root.right, ans);

        return ans;
    }

    private boolean isLeaf(Node root) {

        return root.left == null && root.right == null;
    }

    private void leftBoundary(Node root, ArrayList<Integer> ans) {

        if (root == null || isLeaf(root))
            return;

        ans.add(root.data);

        if (root.left != null)
            leftBoundary(root.left, ans);
        else
            leftBoundary(root.right, ans);
    }

    private void leaves(Node root, ArrayList<Integer> ans) {

        if (root == null)
            return;

        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        leaves(root.left, ans);
        leaves(root.right, ans);
    }

    private void rightBoundary(Node root, ArrayList<Integer> ans) {

        if (root == null || isLeaf(root))
            return;

        if (root.right != null)
            rightBoundary(root.right, ans);
        else
            rightBoundary(root.left, ans);

        ans.add(root.data);
    }
}