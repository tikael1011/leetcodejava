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

//11ms
//30.93%

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

//10ms
//44%
//backtracking

public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    partition(ans, new ArrayList<String>(), s, 0);
    return ans;
}

private void partition(List<List<String>> ans, ArrayList<String> part,
		String s, int start) {
	if (start == s.length()) {
		List<String> li = new ArrayList<>(part);
		ans.add(li);
	}
	for (int i = start; i < s.length(); i++) {
		if (isParlindrome(s.substring(start, i+1))){
			part.add(s.substring(start, i+1));
			partition(ans, part, s, i+1);
			part.remove(part.size() - 1);
		}
	}
}

private boolean isParlindrome(String s) {
	int l = 0, r = s.length()-1;
	while (l < r) {
		if (s.charAt(l) != s.charAt(r)) 
			return false;
		l++; r--;
	}
	return true;
}

//different idea
//10ms
/*
Here the pair is to mark a range for the substring is a Pal. if pair[i][j] is true,
that means sub string from i to j is pal.

The result[i], is to store from beginng until current index i (Non inclusive),
all possible partitions. From the past result we can determine current result.
*/
public class Solution {
 	public static List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] pair = new boolean[len][len];
		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
					pair[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}
}
