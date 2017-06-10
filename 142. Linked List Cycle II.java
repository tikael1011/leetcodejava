/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner){
                ListNode ref = head;
                while(walker != head){
                    walker = walker.next;
                    head = head.next;
                }
                return walker;
            }
        }
        return null;
    }
}
