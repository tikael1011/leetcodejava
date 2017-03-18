/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

//O(n^2) tc, O(n) stack space, brute force

public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    return lefttree(root.left, root.val) && righttree(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
}

private boolean lefttree(TreeNode p ,int val){
    if (p == null) return true;
    return (p.val < val) && lefttree(p.left,val) && lefttree(p.right, val);
}

private boolean righttree(TreeNope p, int val){
    if (p == null) return true;
    return (p.val > val) && righttree (p.left,val) && righttree (p.right, val);
}


//recursion, if the tree does not contains INTEGER.MAX/MIN     O(n) tc ,O(n) space

public boolean isValidBST(TreeNode root) {
    return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean valid(TreeNope p,int low, int high){
    if (p == null) return true;
    return p.val > low && p.val < high && valid(p.left,low,p.val) && valid(p.right,p.val,high);
}

// with MAX/MIN 
/*attention Integer can be null, int can't*/

public boolean isValidBST(TreeNode root) {
    return valid(root, null, null);
}

private boolean valid(TreeNope p,Integer low, Integer high){
    if (p == null) return true;
    return (low == null || p.val > low) && (high == null || p.val < high) && valid(p.left,low,p.val)
    && valid(p.right,p.val,high);
}

