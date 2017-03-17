/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

// O(n)tc ,O(logn) stack space-- divide and conquer

// 1ms

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayBST(nums,0,nums.length-1);
    }
    
    private TreeNode sortedArrayBST(int[] arr, int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayBST(arr,start, mid-1);
        node.right = sortedArrayBST(arr, mid+1, end);
        return node;
    }
}
