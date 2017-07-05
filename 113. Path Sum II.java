/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]


*/


//The idea is dfs, personaly I like the second since it explictly point out when root.left or root.right == null

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>>ret = new ArrayList<List<Integer>>(); 
    List<Integer> cur = new ArrayList<Integer>(); 
    pathSum(root, sum, cur, ret);
    return ret;
}

public void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
    if (root == null){
        return; 
    }
    cur.add(root.val);
    if (root.left == null && root.right == null && root.val == sum){
        ret.add(new ArrayList(cur));
    }else{
        pathSum(root.left, sum - root.val, cur, ret);
        pathSum(root.right, sum - root.val, cur, ret);
    }
    cur.remove(cur.size()-1);
}


// or the following

public void pathSumInner(TreeNode root, int sum, List<Integer>path, List<List<Integer>> result) {
    path.add(root.val);
    if(root.left == null && root.right == null)
        if(sum == root.val) result.add(new ArrayList<Integer>(path));
    if(root.left!=null) pathSumInner(root.left, sum-root.val, path, result);
    if(root.right!=null)pathSumInner(root.right, sum-root.val, path, result);
    path.remove(path.size()-1);
}

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    if(root==null) return resultList;
    List<Integer> currentPath = new ArrayList<Integer>();
    pathSumInner(root, sum, currentPath, resultList);
    return resultList;
}
