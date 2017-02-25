/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
"pwke" is a subsequence and not a substring.
*/

//52ms
//78.06%


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}

//if use hashmap,we can just put "i = map[s[j]] + 1" for the next start positon.
//40ms
//97.93%

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int max = 0, j = 0;
        char[] str = s.toCharArray();
        int length = s.length();
    
        for(int i = 0; i < length; i++) {
            if(map[str[i]] > 0)
                j =  Math.max(j, map[str[i]]);
            map[str[i]] = i + 1;
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
