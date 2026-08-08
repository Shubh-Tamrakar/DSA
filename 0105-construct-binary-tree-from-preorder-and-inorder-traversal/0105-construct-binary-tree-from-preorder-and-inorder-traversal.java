class Solution {

    ArrayList<Integer> list = new ArrayList<>();
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int ele : inorder) {
            list.add(ele);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {

        if (left > right)
            return null;

        int point = preorder[i++];

        TreeNode curr = new TreeNode(point);

        int index = list.indexOf(point);

        curr.left = build(preorder, left, index - 1);
        curr.right = build(preorder, index + 1, right);

        return curr;
    }
}