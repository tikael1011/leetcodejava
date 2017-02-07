/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

//WRONG, nullpointerexception

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA.val == headB.val && headA.next == headB.next){
            return headA.next;
        }
        getIntersectionNode(ListNode (headA.next), ListNode headB);
        getIntersectionNode(ListNode headA, ListNode (headB.next));
        return null;
    }
}


/*
I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don't care about the "value" of difference, we just want to make sure
two pointers reach the intersection node at the same time.

We can use two iterations to do that. In the first iteration, we will reset the
pointer of one linkedlist to the head of another linkedlist after it reaches the
tail node. In the second iteration, we will move two pointers until they points 
to the same node. Our operations in first iteration will help us counteract the
difference. So if two linkedlist intersects, the meeting point in second iteration
must be the intersection point. If the two linked lists have no intersection at all,
then the meeting pointer in second iteration must be the tail node of both lists, which is null

Below is my commented Java code:
*/
//3ms

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}

//length method
//2ms

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}
