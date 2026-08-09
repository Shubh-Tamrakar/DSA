/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        return help(root,list);
    }
    private ArrayList<Integer> help (Node root , ArrayList<Integer> list) {
        if(root == null) {
            return null;
        }
       help(root.left , list);
       
       list.add(root.data);
       
       help(root.right , list);
       
       return list;
    }
}