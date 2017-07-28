/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go 
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/

//ituitive DFS recursion with O(n) sc and worst case O(n^2) best case O(NlogN) rc (balanced tree)

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}

//two-sum hashmap solution, which has O(n) rc
//the key is too find frequency of 'currsum' and get rid of it

public int pathSum(TreeNode root, int sum) {
      if (root == null) {
          return 0;
      }
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      return findPathSum(root, 0, sum, map);  
  }
  private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
      if (curr == null) {
          return 0;
      }
      // update the prefix sum by adding the current val
      sum += curr.val;
      // get the number of valid path, ended by the current node
      int numPathToCurr = map.getOrDefault(sum-target, 0); 
      // update the map with the current sum, so the map is good to be passed to the next recursion
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      // add the 3 parts discussed in 8. together
      int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                                             + findPathSum(curr.right, sum, target, map);
     // restore the map, as the recursion goes from the bottom to the top
      map.put(sum, map.get(sum) - 1);
      return res;
  }
