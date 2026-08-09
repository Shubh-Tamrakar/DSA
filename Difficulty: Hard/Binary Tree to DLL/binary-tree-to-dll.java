/* Structure for tree and linked list
class Node {
  public int data;
  public Node left, right;

  public Node(int x) {
      data = x;
      left = right = null;
  }
};*/
class Solution {

    public Node treeToDLL(Node root) {

        ArrayList<Node> list = new ArrayList<>();

        inorder(root, list);

        for (int i = 0; i < list.size(); i++) {

            if (i > 0)
                list.get(i).left = list.get(i - 1);

            if (i < list.size() - 1)
                list.get(i).right = list.get(i + 1);
        }

        return list.get(0);
    }

    private void inorder(Node root, ArrayList<Node> list) {

        if (root == null)
            return;

        inorder(root.left, list);

        list.add(root);

        inorder(root.right, list);
    }
}