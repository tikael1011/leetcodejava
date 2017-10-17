/*
Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
*/


// The solution is Resverouir sampling. Solution without follow-up is trivia.
// for the input is a large stream of data, size unknown or change dynamicaly...
// http://www.geeksforgeeks.org/reservoir-sampling/
// https://en.wikipedia.org/wiki/Reservoir_sampling
// The weighted one is pretty useful in data science
// And there is another source in Chinese



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */

    ListNode head;
    
    public Solution(ListNode h) {
        head = h;               
    }
    
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        ListNode node = head;
        ListNode candidate = head;
        while (true) {
            if (node == null) break;
            if (rand.nextInt(count + 1) == count) candidate = node; //nth, 1/n
            node = node.next;
            count++;
        }
        return candidate.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
 
 
 /*
 class Solution(object):

    def __init__(self, head):
        self.head = head

    def getRandom(self):
        result, node, index = self.head, self.head.next, 1
        while node:
            if random.randint(0, index) is 0:
                result = node
            node = node.next
            index += 1
        return result.val
 */
