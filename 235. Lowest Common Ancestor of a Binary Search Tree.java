/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two 
nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to
be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes
2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
*/

//check wiki:https://en.wikipedia.org/wiki/Binary_search_tree

//the Key to solve this problem is that the key in each node must be greater than all keys
//stored in the left sub-tree, and not greater than any key in the right sub-tree
//http://articles.leetcode.com/determine-if-binary-tree-is-binary/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//8ms
//top-->down
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}

//non-recursive version
//10ms maybe 9 ms next time?
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }
}

/*
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - (long)p.val) * (root.val - (long)q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
    return root;
}*/
