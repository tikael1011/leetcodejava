/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/



/*
class Solution {
    public String minWindow(String S, String T) {
        
        if (S.length()==0||T.length()==0||S.length()<T.length()) return "";
        
        int left=T.length(),start=-1,end=S.length();
        
        Deque<Integer> queue= new LinkedList<Integer>();
        
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        
        for (int i=0;i<T.length();i++){
            char c= T.charAt(i);
            map.put(c,map.containsKey(c)?map.get(c)+1:1);
        }
        
        for (int i =0;i<S.length();i++){
            char c= S.charAt(i);
            if (!map.containsKey(c))
                continue;
            
            int n = map.get(c);
            map.put(c,n-1);
            queue.add(i);
            if (n>0) left--;
            
            char head = S.charAt(queue.peek());
            while(map.get(head)<0){
            	queue.poll();
            	map.put(head,map.get(head)+1);
            	head=S.charAt(queue.peek());
            }
            
            if (left==0){
            	int new_length=queue.peekLast()-queue.peek()+1;
            	if (new_length<end-start) {
            	    start=queue.peek();
            	    end=queue.peekLast()+1;
            	} 
            }
        }
        if (left==0)  return S.substring(start,end);
        else return "";
    }
}

*/
