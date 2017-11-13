/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root):
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root
            
'''
There are DFS / BFS / use a stack solution as well, and the point is, the recursion may cause stackoverflow.
https://discuss.leetcode.com/topic/21271/python-solutions-recursively-dfs-bfs
'''
