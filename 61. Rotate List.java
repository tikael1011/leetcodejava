/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //without counting length, but this get TLE?
 
 class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
             return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode newHead;
        for (int i = 0; i < n; i++) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head; //make a "circle"
        newHead = slow.next; //new head since i<n,
        slow.next = null;//tail becomes null
        return newHead;
    }
}

//with counting length and no dummy head

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int size = 1; // since we are already at head node
        ListNode fast=head;
        ListNode slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        for(int i=size-k%size;i>1;i--) // i>1 because we need to put slow.next at the start.
            slow = slow.next;

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
