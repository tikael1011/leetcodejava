/*
Given a singly linked list L: L0?L1?…?Ln-1?Ln,
reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

//In space means no recursion, stack/hashmap/... is allowed.

//The idea is three steps:
// find mid
// reverse the 'right'/2nd half
// merge
// do not forget to deal with both null/empty inputs.

public void reorderList(ListNode head) {
    if (head == null || head.next == null)
        return;

    ListNode prev = null, slow = head, fast = head;
    
    // step 1. find the mid
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    // step 2. reverse the 2nd half
    slow = reverse(slow);

    // step 3. merge the two halves
    merge(head, slow);
}

private ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head, next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
}
    
private void merge(ListNode l1, ListNode l2) {
    while (l1 != null) {
      ListNode n1 = l1.next, n2 = l2.next;
      l1.next = l2;

      if (n1 == null)
        break;

      l2.next = n1;
      l1 = n1;
      l2 = n2;
    }
}

//Python solution
/*
def _splitList(head):
    fast = head
    slow = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next
        fast = fast.next

    middle = slow.next
    slow.next = None

    return head, middle

# Reverses in place a list.
# @return Returns the head of the new reversed list
def _reverseList(head):

  last = None // This is very important, very easy forget to do this.
  currentNode = head

  while currentNode:
    nextNode = currentNode.next
    currentNode.next = last
    last = currentNode
    currentNode = nextNode

  return last

# Merges in place two lists
# @return The newly merged list.
def _mergeLists(a, b):

    tail = a
    head = a

    a = a.next
    while b:
        tail.next = b
        tail = tail.next
        b = b.next
        if a:
            a, b = b, a
            
    return head


class Solution:

    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):

        if not head or not head.next:
            return

        a, b = _splitList(head)
        b = _reverseList(b)
        head = _mergeLists(a, b)
*/
