/*
Given a string which consists of lowercase or uppercase letters,
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/


//22ms
public class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        char[] ref = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int res;
        for(int i =0; i < ref.length;i++) {
            res = (int)ref[i];
            if(map.containsKey(res)) {
                map.remove(res);
                continue;
            }
            map.put(res,i);
        }
        if(map.size()==0) return s.length();
        return (map.size()==1&&s.length()%2==0)?(s.length()-map.size()):(s.length()-map.size()+1);
    }
}

//20ms
// hashset

public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int odd = set.size();
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }
    
    
//10ms   BEST
/*
Just check for pairs in the String and increment max_length.
At the end compare the String length and max_length to determine whether the whole string is a palindrome or not.
O(n) solution.
*/
public class Solution {
    public int longestPalindrome(String s) {
        if(s==null|| s.length()==0)
        return 0;
        if(s.length()==1)
        return 1;
        
        int[] alpha=new int[128];
        int max_length=0;
        for(char c:s.toCharArray()){
            alpha[c]++;
            if(alpha[c]==2)
            {
                max_length+=2;
                alpha[c]=0;
            }
        }
        if(s.length()>max_length)
         return max_length+1;
        else
         return max_length;
        
    }
}
