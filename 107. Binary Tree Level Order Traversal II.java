/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

//using a linkedlist method. addFirst instead of list add.(index, element) is faster
//and there is another 'easy' way, add then reverse().
//and there is other 'traditional' way, using a stack or queue, or Deque.

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        traverse(list, 0 , root);
        return list;
    }

    private void traverse(LinkedList<List<Integer>> list, int level, TreeNode node){
        if(node == null) return;
        if(list.size() - 1 < level) list.addFirst(new ArrayList<Integer>());
        list.get(list.size() - level - 1).add(node.val);
        traverse(list, level + 1, node.left);
        traverse(list, level + 1, node.right);
    }
}
