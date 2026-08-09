/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
}*/

class Solution {
    Node lca(Node root, int n1, int n2) {
        // code here
        

    //public TreeNode lowestCommonAncestor(Node root, Node p, Node q) {

        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        help(root, n1, list1);
        help(root, n2, list2);

        int i = 0;
        Node ans = null;

        while (i < list1.size() && i < list2.size()) {

            if (list1.get(i) != list2.get(i))
                break;

            ans = list1.get(i);
            i++;
        }

        return ans;
    }

    private boolean help(Node root, int node,
                         ArrayList<Node> list) {

        if (root == null)
            return false;

        list.add(root);

        if (root.data == node)
            return true;

        if (help(root.left, node, list))
            return true;

        if (help(root.right, node, list))
            return true;

        list.remove(list.size() - 1);

        return false;
    }
}
