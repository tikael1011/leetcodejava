/*
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
*/

public int rob(TreeNode root) {
    int[] maxVal = dpRob(root);
    return Math.max(maxVal[0], maxVal[1]);
}

public int[] dpRob(TreeNode root) {
    if (root == null) {
        return new int[]{0, 0};
    } else {
        int[] maxVal = new int[2];
        //maxVal[0] store the max value without robing current node,
        //maxVal[1] store the max value with robing current node,
        int[] leftMax = dpRob(root.left);
        int[] rightMax = dpRob(root.right);
        maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
        maxVal[1] = leftMax[0] + rightMax[0] + root.val;
        return maxVal;
    }
}


//but if we try to put the two cases together, it is slow because we will have overrlapping problems

public int rob(TreeNode root) {
    return robSub(root, new HashMap<>());
}

private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
    if (root == null) return 0;
    if (map.containsKey(root)) return map.get(root);
    
    int val = 0;
    
    if (root.left != null) {
        val += robSub(root.left.left, map) + robSub(root.left.right, map);
    }
    
    if (root.right != null) {
        val += robSub(root.right.left, map) + robSub(root.right.right, map);
    }
    
    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
    map.put(root, val);
    
    return val;
}
