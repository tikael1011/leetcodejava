/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/


public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<String>());
        return result;
    }        
    
    public void helper(String s, List<String> cur){                 //DFS every combinations
        if(s.length() == 0){result.add(cur); return;}        
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0,i);
            if(isPal(sub)){
                List<String> newList = new ArrayList<String>(cur);
                newList.add(sub);
                helper(s.substring(i,s.length()), newList);
            }
            else continue;                                    //not palindrome, ignore it
        }        
    }                
    
    public boolean isPal(String str){
        int l = 0;
        int r = str.length()-1;
        while(l <= r){
            if(str.charAt(l) != str.charAt(r))  return false;
            l++;r--;
        }
        return true;
    }
} 
