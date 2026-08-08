import java.util.*;

public class Codec {

    // Serialize: Tree -> String
    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();

            if (curr == null) {
                ans.append("null,");
                continue;
            }

            ans.append(curr.val).append(",");

            q.add(curr.left);
            q.add(curr.right);
        }

        return ans.toString();
    }


    // Deserialize: String -> Tree
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty())
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            TreeNode curr = q.poll();

            // Left child
            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }
}