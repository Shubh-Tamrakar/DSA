/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}*/

class Solution {
   // public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
       
    class Info {
        Node node;
        int hd;
        int level;

        Info(Node node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(root, 0, 0));

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {

            Info curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, new ArrayList<>());
            }

            map.get(curr.hd).add(curr.node.data);

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

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {

            ArrayList<Integer> list = map.get(i);

            //ollections.sort(list);

            ans.add(list);
        }

        return ans;
    }
}