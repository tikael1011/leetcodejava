//Sort a linked list using insertion sort.

//the wiki for insertion sort.

//in-space, fake/dummy head.

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
