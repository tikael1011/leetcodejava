//Sort a linked list using insertion sort.

//the wiki for insertion sort.

//in-space, fake/dummy head.


//45ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
      ListNode curr = head, next = null;
      ListNode l = new ListNode(-1);

      while (curr != null) {
        next = curr.next;
        ListNode p = l;
        while (p.next != null && p.next.val < curr.val) p = p.next;
        curr.next = p.next;
        p.next = curr;
        curr = next;
      }
      return l.next;
    }
}


//the ablove algritm has one improvement. We do not need to go through the entire linkedlist to insert a 'largest'
//new element, we can keep track of the largest element in current linkedlist, and if new node.val > temp tail.val,
//we add it and make it become the new tail directly.
//see following, the rc has been reduced greatly to 7ms.


public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null)
    {
        return head;
    }

    ListNode sortedHead = head, sortedTail = head;
    head = head.next;
    sortedHead.next = null;
    
    while (head != null)
    {
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        
        // new val is less than the head, just insert in the front
        if (temp.val <= sortedHead.val)
        {
            temp.next = sortedHead;
            sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
            sortedHead = temp;
        }
        // new val is greater than the tail, just insert at the back
        else if (temp.val >= sortedTail.val)
        {
            sortedTail.next = temp;
            sortedTail = sortedTail.next;
        }
        // new val is somewhere in the middle, we will have to find its proper
        // location.
        else
        {
            ListNode current = sortedHead;
            while (current.next != null && current.next.val < temp.val)
            {
                current = current.next;
            }
            
            temp.next = current.next;
            current.next = temp;
        }
    }
    
    return sortedHead;
}
