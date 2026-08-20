/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution { 

      int ans; 

      int maxDiff(Node root) { 

          ans = Integer.MIN_VALUE;  

          findMin(root); 

          return ans; 
      } 

      int findMin(Node root) { 

          if (root == null) 
              return Integer.MAX_VALUE; 

          int leftMin = findMin(root.left); 
          int rightMin = findMin(root.right); 

          int minValue = Math.min(root.data, 
                  Math.min(leftMin, rightMin)); 

          if (leftMin != Integer.MAX_VALUE)
              ans = Math.max(ans, root.data - leftMin); 

          if (rightMin != Integer.MAX_VALUE)
              ans = Math.max(ans, root.data - rightMin); 

          return minValue; 
      } 
  }