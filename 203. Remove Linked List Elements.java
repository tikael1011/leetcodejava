/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


//Immedicatelly, two solutions come to my mind, recursive and iterative.

//recursive

public ListNode removeElements(ListNode head, int val) {
    if(head == null) return null;
    ListNode next = removeElements(head.next, val);
    if(head.val == val) return next;
    head.next = next;
    return head;
}

public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}

//iterative

public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    
    while(cur.next != null) {
        if(cur.next.val == val) {
            cur.next = cur.next.next;
        }
        else
            cur = cur.next;
    }
    return dummy.next;
}
