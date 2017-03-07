/*
Given two strings S and T, determine if they are both one edit distance apart.

Hint:

consider S.length() == T.length() and S.length() != T.legnth() separately.
assume  m = S.length(), n = T.length()
*/


//DP solution ,O(mn) and space complexity O(min(m,n))

//O(n) runtime, O(1) space

public boolean isOnEditDistance(String s, String t){
  int m = s.length(), n = t.length();
  if(m > n) return isOnEditDistance(t, s); // assume m<=n, otherwise swap  m,n
  if(n - m > 1) return false;
  int i = 0, diff = n - m;
  while(i < m && (s.charAt(i) == t.charAt(i))) i++;
  if(i == m) return diff > 0;
  if(diff == 0) i++;
  while(i < m && (s.charAt(i) == t.charAt(i + diff))) i++;
  return i == m;
}
