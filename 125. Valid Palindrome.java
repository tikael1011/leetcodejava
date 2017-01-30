/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/



//30ms
//21.28%
public class Solution {
    public static boolean isPalindrome(String s) {
    	s = s.replaceAll("[^A-Za-z0-9]", "");
    	for(int i =0;i<s.length()/2;i++){
    		if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(s.length()-1-i)))
    			continue;
    		else 
    			return false;
    	}
    	return true;
    }
}

//8ms
//73.09%
// two pointer method, avoid REX

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head < tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
