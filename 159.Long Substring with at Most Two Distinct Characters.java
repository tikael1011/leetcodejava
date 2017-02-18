/*
Given a string S, find the length of the longest substring T that contains at most TWO distinct characters.
eg. S = "eceba"
T = "ece" which has length 3.
*/

public int longestsubstring(String s){
  int i = 0, j = -1, res = 0;
  for(int k =1; k < s.length(); k++){
      if(s.charAt(k)==s.charAt(k-1)) continue;
      if(j>=0 && s.charAt(j) != s.charAt(k)){
        res = Math.max(k-i,res);
        i = j + 1;
      }
      j = k -1;
    }
    return Math.max(s.length()-i,res);
}
