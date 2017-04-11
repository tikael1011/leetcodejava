//medium

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

//O(NlgN) runtime, O(lgN) stack space-- Brute Force
//O(N) runtime,O(lgN) stack space-- Bottom-up recursion

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode list;

    private TreeNode sortedListToBST(int start, int end){
      if (start > end) return null;
      int mid = (start + end) / 2;
      TreeNode leftchild = sortedListToBST(start, mid-1);
      TreeNode parent = new TreeNode(list.val);
      parent.left = leftchild;
      list = list.next;
      parent.right = sortedListToBST(mid+1, end);
      return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head){
      int n = 0;
      ListNode p = head;
      while(p!= null){
        p= p.next;
        n++;
      }
      list = head;
      return sortedListToBST(0,n-1);
    }
}
