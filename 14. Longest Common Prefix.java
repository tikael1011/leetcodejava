/*
Write a function to find the longest common prefix string amongst an array of strings.
*/


//11ms
//70%
//find the shortest string

public class Solution {
    public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int numOfArr = strs.length;
		int lenOfStr = strs[0].length();
		for (int i = 1; i < numOfArr; i++) {
			if (strs[i].length() < lenOfStr)
				lenOfStr = strs[i].length();
		}
		
		for (int i = 0; i < lenOfStr; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < numOfArr; j++) {
				if (strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		
		return strs[0].substring(0, lenOfStr);
    }
}

//another thought

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n==0) return "";
        StringBuilder st=new StringBuilder(strs[0]);
        for(int i=1;i<n;i++){
            while(!strs[i].startsWith(st.toString())) st.deleteCharAt(st.length()-1);
        }
        return st.toString();
    }
}

//another method: sort the input then compare the first and last is O(knlogn)...soooooo slow..forget it
