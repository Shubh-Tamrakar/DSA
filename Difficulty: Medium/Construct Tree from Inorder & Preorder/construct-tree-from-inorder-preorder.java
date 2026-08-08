class Solution {

    ArrayList<Integer> list = new ArrayList<>();
    int i = 0;

    public static Node buildTree(int inorder[], int preorder[]) {
        
        Solution obj = new Solution();

        for (int x : inorder) {
            obj.list.add(x);
        }

        return obj.build(preorder, 0, inorder.length - 1);
    }

    public Node build(int preorder[], int left, int right) {

        if (left > right)
            return null;

        int point = preorder[i++];

        Node curr = new Node(point);

        int index = list.indexOf(point);

        curr.left = build(preorder, left, index - 1);
        curr.right = build(preorder, index + 1, right);

        return curr;
    }
}