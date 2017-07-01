/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

//DP solution
// RC is HORRIBLE O(wordDict.length * word.length()*n^2)

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] map = new boolean[n+1];
        map[0] = true;
        for(int i = 1; i < n +1; i++){
            for(int j = 0; j< i;j++){
                for(String word: wordDict){
                    if (map[j]  && s.substring(j,i).equals(word)){
                        map[i] = true;
                        break;
                    }
                }
            }
        }
        return map[n];
    }
}

//java list also has .contains method,
/*
for(int i = 1; i < n +1; i++){
            for(int j = 0; j< i;j++){
                if (map[j]  && wordDict.contains(s.substring(j,i))){
                    map[i] = true;
                    break;
                }
                
            }
        }
*/

//python

/*
class Solution(object):
    def wordBreak(self, s, words):
        ok = [True]
        for i in range(1, len(s)+1):
            ok += any(ok[j] and s[j:i] in words for j in range(i)),
        return ok[-1]
*/
