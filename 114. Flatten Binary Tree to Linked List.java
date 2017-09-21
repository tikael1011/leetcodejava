/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

//Since the requirement is in-space, means O(1) sc, so technically the stack iterative methods is not accecpted.
//The average case O(lgN) but the worst case could be O(n).

/*
Iterative solution

   public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            curr.left = null;  //*** dont forget this ***//
        }
    }
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        flatten(root,null);
    }
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);    
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null; //*** make sure the null ***//
        pre=root;
        return pre; 
    }
}
