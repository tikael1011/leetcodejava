/*
Find the length of the longest substring T of a given string (consists of lowercase letters only)
such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

//The idea is D&C, find every char that does not repeat k times, split original string by char and recursive call
//the same function


/*
def longestSubstring(self, s, k):
    for c in set(s):
        if s.count(c) < k:
            return max(self.longestSubstring(t, k) for t in s.split(c))
    return len(s)
*/

public int longestSubstring(String s, int k) {
       if (s == null || s.length() == 0 || k == 0) return 0;
       int max = 0;
       int[] count = new int[26];
       int res = 0;
       for (int i = 0; i < s.length(); i++) {
           count[s.charAt(i) - 'a']++;
       }
       List<Integer> pos = new ArrayList<Integer>();
       for (int i = 0; i < s.length(); i++) {
           if (count[s.charAt(i) - 'a'] < k) pos.add(i);
       }
       if (pos.size() == 0) return s.length();
       pos.add(0, -1);
       pos.add(s.length());
       for (int i = 1; i < pos.size(); i++) {
           int start = pos.get(i-1) + 1;
           int end = pos.get(i);
           int next = longestSubstring(s.substring(start, end), k);
           res = Math.max(res, next);
       }
       return res;
   }
