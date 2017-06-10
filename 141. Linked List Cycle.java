/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/


//https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare


public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head.next;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}


//or just 

public boolean hasCycle(ListNode head) {
    if(head==null) return false;
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
        walker = walker.next;
        runner = runner.next.next;
        if(walker==runner) return true;
    }
    return false;
}
