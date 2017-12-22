/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST 
such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

//Solution 1: O(n) rc and sc, most intuitive.
//This can be regarded as a follow-up question for original two sum.
//'what if input array is sorted'? The answer is using two pointers,
//thus no need to build a hashmap.
//then this problem becomes to how to convert a BST in-order transval into a sorted array.

List<Integer> sortedlist = new ArrayList<>();

private void sortBST(TreeNode root, List<Integer> sortedlist) {
    if (root == null) return;

    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
}

/***HIGHLIGHT***/
//Solution 2: Given lc173. BST iterator
//there is one O(n)rc and O(lg(n)) / O(h), where h is the height of the tree, sc solution.
//using one/two stack to generate/store "min/max" val accordingly.

public boolean findTarget(TreeNode root, int k) {
    if(root == null) return false;
    Stack<TreeNode> l_stack = new Stack<>();
    Stack<TreeNode> r_stack = new Stack<>();
    stackAdd(l_stack, root, true);
    stackAdd(r_stack, root, false);
    while(l_stack.peek() != r_stack.peek()){
        int n = l_stack.peek().val + r_stack.peek().val;
        if(n == k){
            return true;
        }else if(n > k){
            stackNext(r_stack, false);
        }else{
            stackNext(l_stack, true);
        }
    }
    return false;
}

private void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft){
    while(node != null){
        stack.push(node);
        node = (isLeft) ? node.left : node.right;
    }
}

private void stackNext(Stack<TreeNode> stack, boolean isLeft){
    TreeNode node = stack.pop();
    if(isLeft){
        stackAdd(stack, node.right, isLeft);
    }else{
        stackAdd(stack, node.left, isLeft);
    }
}
    
