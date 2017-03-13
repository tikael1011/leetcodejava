/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

/*
DP: P[i,j] iff P[i+1,j-1]
base case P[i,i]->T
P[i,i+1]->T

O(n^2) tc, O(n^2)space

*/


/**
the key thought is that we can expand a palindrome from the corner
and there is 2n-1 possible center

O(n^2) tc, O(1) space
**/


//21ms
//70.48%


public String longestPalindrome(String s){
  int start = 0, end = 0;
  for(int i =0; i < s.length(); i++){
    int l1 = expandcenter(s,i,i);
    int l2 = expandcenter(s,i,i+1);
    int len = Math.max(l1,l2);
    if(len > (end - start)){
      start = i - (len-1)/2;
      end = i + len/2;
    }
  }
  return s.substring(start,end+1);
}

private int expandcenter(String s, int left, int right){
  int l = left, r = right;
  while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
    l--;
    r++;
  }
  return r-l-1;
}


//there is  O(n) tc, O(n) space --Manacher's algorithm
