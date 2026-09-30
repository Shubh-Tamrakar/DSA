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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> fin = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
         if(root == null) return fin;
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
           
            int size = q.size();
            for(int i =0;i<size;i++) {
                 TreeNode node = q.remove();
                 curr.add(node.val);
                  if(node.left != null) q.add(node.left);
                  if(node.right!= null) q.add(node.right);

            }
            fin.add(curr);

        }
        return fin;

    }
}