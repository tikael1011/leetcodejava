/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

//there are two main ideas, the first one is of course the recursive one, which is the following algorithm:
/*
1. Find the root from preorder array, of which is preorder[0], then find the root index in inorder array
2. Elements left of the index in inorder array are the left subtree, and elements in right are the right subtree
3. recursively call func on left part of inorder array, and add the new root as left child of the original root.
4. recursively call func on right part of inorder array, and add the new root as right child of the original root.
5. if not more element (remained/left) in array, return the very first root.
*/
// https://discuss.leetcode.com/topic/10693/concise-java-recursive-solution
// this implementation shows the algorithm exactly, it is like crystal clear,
// but IMHO, is NOT RECOMMENDED, why? see Python part.

public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder==null || inorder==null || inorder.length==0 || preorder.length==0) return null;
    TreeNode root = new TreeNode(preorder[0]);
    if(preorder.length==1) return root;
    int breakindex = -1;
    for(int i=0;i<inorder.length;i++) { if(inorder[i]==preorder[0]) { breakindex=i; break;} }
    int[] subleftpre  = Arrays.copyOfRange(preorder,1,breakindex+1);
    int[] subleftin   = Arrays.copyOfRange(inorder,0,breakindex);
    int[] subrightpre = Arrays.copyOfRange(preorder,breakindex+1,preorder.length);
    int[] subrightin  = Arrays.copyOfRange(inorder,breakindex+1,inorder.length);
    root.left  = buildTree(subleftpre,subleftin);
    root.right = buildTree(subrightpre,subrightin);
    return root;
}

//there is python implementation, but some people claims it got MLE (memory limit exceed)
/*
def buildTree(self, preorder, inorder):
    if inorder:
        ind = inorder.index(preorder.pop(0))
        root = TreeNode(inorder[ind])
        root.left = self.buildTree(preorder, inorder[0:ind])
        root.right = self.buildTree(preorder, inorder[ind+1:])
        return root
*/
// The reason is that, as the other people pointed out, every time list silcing is called, it makes a copy and takes
// O(K) space, where K is the length the copy. So an alternative is using a helper function and explicitly point
// out starting and ending index for both preorder and inorder array. as following:

public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length!=inorder.length) return null;
    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
}

public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
    if(preLow>preHigh || inLow>inHigh) return null;
    TreeNode root = new TreeNode(preorder[preLow]);
   
    int inorderRoot = inLow;
    for(int i=inLow;i<=inHigh;i++){
        if(inorder[i]==root.val){ inorderRoot=i; break; }
    }
   
    int leftTreeLen = inorderRoot-inLow;
    root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
    root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);       
    return root;        
}

// there is still improvement for the above solution. 
// inspired by: https://discuss.leetcode.com/topic/29838/5ms-java-clean-solution-with-caching
// use a hashmap to cache both value and index to speedup lookup time.
// this O(n) sc trade-off results in a O(1) rc search:

public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
    
    for(int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    return root;
}

public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
    if(preStart > preEnd || inStart > inEnd) return null;
    
    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;
    
    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
    
    return root;
}

/*------###------*/

// the following in an iterative solution
// idea is to use a 'classic' stack. It is actually a brilliant idea because we can get rid of 'copy' subarray.
// and it is DAMN fast. 4ms vs 22ms (non-cache-optimized recursion)

public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;
    Stack<TreeNode> s = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]), cur = root;
    for (int i = 1, j = 0; i < preorder.length; i++) {
        if (cur.val != inorder[j]) {
            cur.left = new TreeNode(preorder[i]);
            s.push(cur);
            cur = cur.left;
        } else {
            j++;
            while (!s.empty() && s.peek().val == inorder[j]) {
                cur = s.pop();
                j++;
            }
            cur = cur.right = new TreeNode(preorder[i]);
        }
    }
    return root;
}
