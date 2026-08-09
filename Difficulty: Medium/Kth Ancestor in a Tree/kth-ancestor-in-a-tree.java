/* Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int kthAncestor(Node root, int k, int node) {
        // code here
        ArrayList<Node>list = new ArrayList<>();
        
        return help(root, k , node , list);
        
    }
    
    private int help(Node root , int k , int node , ArrayList<Node> list) {
        if(root == null) return -1;
        int ans = -1;
        list.add(root);
        if(root.data == node && list.size() > k) {
            
            ans = list.get(list.size() - k - 1).data;
            return ans;
        }
         ans =  help(root.left , k , node ,list);
        if (ans != -1)
            return ans;
         ans = help(root.right , k ,node, list);
        if (ans != -1)
            return ans;
        list.remove(list.size()-1);
        return -1;
    }
}