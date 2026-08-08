/*Structure of binary tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
};*/

class Solution {
    
    int diameter = 0;
    public int diameter(Node root) {
        // code here
       


    
        height(root);
        return diameter;
    }

    public int height(Node root) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        // path passing through current node
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
    