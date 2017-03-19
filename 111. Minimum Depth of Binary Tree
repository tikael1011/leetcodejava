/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

//similar idea to MAX dpeth tree
// O(n) tc, O(logn) space


public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}

// or us BFT , this is good for (highly) unbalanced tree
//but for the worst case(nearly balanced or balanced tree) , O(n) tc O(n) space

public int minDepth(TreeNode root) {
  if (root == null) return 0;
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);
  TreeNode rightMost = root;
  int depth = 1; // if the node is a leaf itself, the depth is one
  while(!q.isEmpty()){
    TreeNode node = q.poll();
    if (node.left == null && node.right == null) break;
    if (node.left != null) q.add(node.left);
    if (node.right != null) q.add(node.right);
    if (node == rightMost){
      depth++;
      rightMost = (node.right != null)? node.right : node.left;
    }
  }
  return depth;
}
