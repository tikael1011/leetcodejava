/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

//The idea is similar to 105, find the very root, split the inorder, then recursively all function.
//some optimal are just ignored.

/*
def buildTree(self, inorder, postorder):
    if inorder:
        ind = inorder.index(postorder.pop())
        root = TreeNode(inorder[ind])
        root.right = self.buildTree(inorder[ind+1:], postorder)
        root.left = self.buildTree(inorder[:ind], postorder)
        return root
*/
