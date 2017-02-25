/*
given two linked list representing two non-negative nmbers. The digits are stored in reverse
order and each of their nodes contains a single digit. Add the two numbers and return it as a linkd list
*/


/*
e.g.
input (2->4->3) + (5->6->4)
output 7->0->8

*/

/**
pay attention to the following two cases:

one list is longer;
(9->9) + (1) = (0->0->1);

**/

//70ms
//10%...
//but this algothrim is good...

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
  ListNode dummyhead = new ListNode(0);
  ListNode p = l1, q = l2, curr = dummyhead;
  int carryover = 0;
  while(p != null || q != null){
    int x = (p != null)? p.val : 0;
    int y = (q != null)? q.val : 0;
    int digit = carryover + x + y;
    carryover = digit / 10;
    curr.next = new ListNode(digit%10);
    curr = curr.next;
    if(p != null) p = p.next;
    if(q != null) q = q.next;
  }
  if(carryover > 0){
    curr.next = new ListNode(carryover);
  }
  return dummyhead.next;
}
