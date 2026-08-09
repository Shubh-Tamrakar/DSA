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

    class Info {
        TreeNode node;
        int hd;
        int level;

        Info(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    class Pair {
        int level;
        int value;

        Pair(int level, int value) {
            this.level = level;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(root, 0, 0));

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {

            Info curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, new ArrayList<>());
            }

            map.get(curr.hd).add(
                new Pair(curr.level, curr.node.val)
            );

            if (curr.node.left != null) {
                q.add(new Info(
                    curr.node.left,
                    curr.hd - 1,
                    curr.level + 1
                ));

                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                q.add(new Info(
                    curr.node.right,
                    curr.hd + 1,
                    curr.level + 1
                ));

                max = Math.max(max, curr.hd + 1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {

            ArrayList<Pair> list = map.get(i);

            Collections.sort(list, (a, b) -> {

                if (a.level != b.level)
                    return a.level - b.level;

                return a.value - b.value;
            });

            ArrayList<Integer> temp = new ArrayList<>();

            for (Pair p : list) {
                temp.add(p.value);
            }

            ans.add(temp);
        }

        return ans;
    }
}