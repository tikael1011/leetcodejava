/*
A linked list is given such that each node contains an additional random
pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */


/**
Both methods are O(n) rc && O(n) sc
*/

//the map method

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // it can be final since the final only means the reference is final
        final Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//cpoy all the nodes
        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
// assign next and random pointers
        
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            final RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        
        return map.get(head);
    }
}


//without map, three(can be two) interations

/*
Step 1: create a new node for each existing node and join them together
eg: A->B->C will be A->A'->B->B'->C->C'

Step2: copy the random links: for each new node n', n'.random = n.random.next

Step3: detach the list: basically n.next = n.next.next; n'.next = n'.next.next
*/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode n = head;
        while (n!=null){
            RandomListNode n2 = new RandomListNode(n.label);
            RandomListNode tmp = n.next;
            n.next = n2;
            n2.next = tmp;
            n = tmp;
        }
        
        n=head;
        while(n != null){
            RandomListNode n2 = n.next;
            if(n.random != null)
                n2.random = n.random.next;
            else
                n2.random = null;
            n = n.next.next;
        }
        
        //detach list
        RandomListNode n2 = head.next;
        n = head;
        RandomListNode head2 = head.next;
        while(n2 != null && n != null){
            n.next = n.next.next;
            if (n2.next == null){
                break;
            }
            n2.next = n2.next.next;
            
            n2 = n2.next;
            n = n.next;
        }
        return head2;
        
    }
}
