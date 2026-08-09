/* A binary tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {

    public int findDist(Node root, int a, int b) {

        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        help(root, a, list1);
        help(root, b, list2);

        int i = 0;

        while (i < list1.size() &&
               i < list2.size() &&
               list1.get(i) == list2.get(i)) {
            i++;
        }

        // i = first different node
        // i-1 = LCA

        return (list1.size() - i) + (list2.size() - i);
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