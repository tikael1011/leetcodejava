/*
Given a string which contains only lowercase letters,
remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/



/*
for "cbacdcbc", we counts each letter's index:

a----2
b----1,6
c----0,3,5,7
d----4
we go from a to d, to find the first letter who has a index smaller than the largest index of the rest.
Here, index 2 of letter a is smaller than 6, 7, 4, so we first pick a;
then we remove all index smaller than 2, and we have:

b----6
c----3,5,7
d----4
the next round we pick c not b, why ? cuz 6 of b is larger than 4, but 3 of c is smaller than 4 and 6.

b---6
d---4
then we pick d and b to form "acdb"

O(n) time to count index, and as we only have 26 letters, it's about O(26 * 26
) to find a candidate letter and O(n) time to remove all index. So I think the running time is O(n).
*/

//6ms
//86.31%

public class Solution {
    public String removeDuplicateLetters(String s) {
    		LinkedList[] repetitions = new LinkedList[26];
    		StringBuilder sb = new StringBuilder();
    		int charCount = 0;
    		int position = 0;
    		for (int i=0;i<s.length();i++){
    			if (repetitions[s.charAt(i)-'a'] == null && ++charCount>0)
    				repetitions[s.charAt(i)-'a'] = new LinkedList<Integer>();
    			repetitions[s.charAt(i)-'a'].add(i);
    		}
    		while (charCount-->0){
    			int smallestLargest = Integer.MAX_VALUE;
    			for (LinkedList<Integer> list :repetitions)
    			    smallestLargest = (list!=null && list.peekLast()<smallestLargest)?list.peekLast():smallestLargest;
    			for (int i=0;i<repetitions.length;i++)
    				if (repetitions[i]!=null && ((LinkedList<Integer>)repetitions[i]).peek()<=smallestLargest){
    					position=((LinkedList<Integer>)repetitions[i]).peek();
    					sb.append(s.charAt(position));
    					repetitions[i] = null;
    					break;
    				}
    			if (charCount>0)
        			for (LinkedList<Integer> list :repetitions)
        				if (list!=null)
        					while (list.peek()<position)
        						list.poll();
        			
    		}
    		return sb.toString();
        }
}

//using stack
//6ms
//using string builder as a stack can reduce time to 5 maybe 4ms.

public String removeDuplicateLetters(String s) {
    Stack<Character> stack = new Stack<>();
    int[] count = new int[26];  //will contain number of occurences of character (i+'a')
    char[] arr = s.toCharArray();
    for(char c : arr) { //count number of occurences of character
        count[c-'a']++;
    }
    boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
    for(char c : arr) {
        count[c-'a']--;  //decrement number of characters remaining in the string to be analysed
        if(visited[c-'a']) {
            continue;
        }
        //if current character is smaller than last character in stack which occurs later in the string again
        //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
        while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) {
            visited[stack.peek()-'a'] = false;
            stack.pop();
        }
        stack.push(c);
        visited[c-'a'] = true;
    }
    StringBuilder sb = new StringBuilder();
    for(char c : stack) {
        sb.append(c);
    }
    return sb.toString();
}

/*
public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] res = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            res[c-'a']++;
        }
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();; // answer stack
        int index;
        for(char c : arr){ 
            index = c - 'a';
            res[index]--;   // decrement number of characters remaining in the string to be analysed
            if(visited[index]) // if character is already present in stack, dont bother
                continue;
            // if current character is smaller than last character in stack which occurs later in the string again
            // it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while( (sb.length() > 0) && c < sb.charAt(sb.length()-1) && res[sb.charAt(sb.length()-1)-'a']!=0){ 
                visited[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c); // add current character and mark it as visited
            visited[index] = true;
        }
        
        return sb.toString();
    }
}
*/

//recursive solution
//As every time when removeDuplicateLetters is called, it goes through the whole string to collect cnt,
//and s.substring(j + 1).replaceAll("" + ch, "") is O(n) as well because it runs through the whole string.

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
