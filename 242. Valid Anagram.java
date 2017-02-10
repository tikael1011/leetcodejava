/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/


//8ms
//if 7 ms then gr8
//37.41%
/*
 if(null == s)
      return (t==null);
    if(t==null || s.length() != t.length())
      return false;
  return Arrays.equals(sa,ta);
*/



public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        Arrays.sort(sa);
        Arrays.sort(ta);
        int i = 0;
        int lens = sa.length;
        int lent = ta.length;
        if(lens != lent) return false;
        while(i<lens){
            if(sa[i]==ta[i++]) continue;
            return false;
        }
        return true;
    }
}


//the following one has much better idea , which in the worst case has O(n)  time.
//7ms
//51.54%
//The idea is simple. It creates a size 26 int arrays as buckets for each letter in alphabet.
//It increments the bucket value with String s and decrement with string t.
//So if they are anagrams, all buckets should remain with initial value which is zero.
//So just checking that and return

public class Solution {
  public boolean isAnagram(String s, String t) {
      int[] alphabet = new int[26];
      for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
      for (int i = 0; i < t.length(); i++) {
        alphabet[t.charAt(i) - 'a']--;
        if(alphabet[t.charAt(i) - 'a'] < 0) return false;
      }
      for (int i : alphabet) if (i != 0) return false;
      return true;
  }
}
