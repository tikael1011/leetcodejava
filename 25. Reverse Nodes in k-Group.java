/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

//since the problem requires constant space, so recursive solution should not be accepted,
//the following is from : https://discuss.leetcode.com/topic/7126/short-but-recursive-java-code-with-comments
/*
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
        curr = curr.next;
        count++;
    }
    if (count == k) { // if k+1 node is found
        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
        while (count-- > 0) { // reverse current k-group: 
            ListNode tmp = head.next; // tmp - next head in direct part
            head.next = curr; // preappending "direct" head to the reversed list 
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
        }
        head = curr;
    }
    return head;
}
*/

//For the other solution, the algorithm is pretty straight forward. find K (k+1)th node, reverse, 
//if not found(head.next = null), return.

//in terms of reverse a linked list, there are at least two (constant space) methods.
//the first one is the traditional reverse direction from start to end,
//the other is delete head.next, append it to tail. repeat until prev.next == tail.

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode begin;
    if (head==null || head.next ==null || k==1)
    	return head;
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    begin = dummyhead;
    int i=0;
    while (head != null){
    	i++;
    	if (i%k == 0){
    		begin = reverse(begin, head.next);
    		head = begin.next;
    	} else {
    		head = head.next;
    	}
    }
    return dummyhead.next;
    
}

public ListNode reverse(ListNode begin, ListNode end){
    ListNode curr = begin.next;
    ListNode next, first;
    ListNode prev = begin;
    first = curr;
    while (curr!=end){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    begin.next = prev;
    first.next = curr;
    return first;
}
