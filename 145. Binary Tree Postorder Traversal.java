/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/


//remind me the use of Deque(double end queue) and other method in it,
//whether return false/null or throws exception. addFirst/offerFirst, remove/pop...


public List<Integer> postorderTraversal(TreeNode root) {
	LinkedList<Integer> ans = new LinkedList<>();
	Stack<TreeNode> stack = new Stack<>();
	if (root == null) return ans;
	
	stack.push(root);
	while (!stack.isEmpty()) {
		TreeNode cur = stack.pop();
		ans.addFirst(cur.val);
		if (cur.left != null) {
			stack.push(cur.left);
		}
		if (cur.right != null) {
			stack.push(cur.right);
		} 
	}
	return ans;
}


//with reverse

public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> results = new ArrayList<Integer>();
	Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	while (!stack.isEmpty() || root != null) {
		if (root != null) {
			stack.push(root);
			results.add(root.val);
			root = root.right;
		} else {
			root = stack.pop().left;
		}
	}
	Collections.reverse(results);
	return results;
}
