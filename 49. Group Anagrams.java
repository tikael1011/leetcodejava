/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/


//32ms
//52.95%

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	//List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        //Arrays.sort(strs);                                    // sort the output is not required
        for (int i = 0; i < strs.length; i++) {
        	String temp = strs[i];
        	char[] ch = temp.toCharArray();
        	Arrays.sort(ch);
        	if (map.containsKey(String.valueOf(ch))) {
        		map.get(String.valueOf(ch)).add(strs[i]);
        	} else {
        		List<String> each = new ArrayList<>();
        		each.add(strs[i]);
        		map.put(String.valueOf(ch), each);
        	}
        }
        
        return new ArrayList(map.values());    // or use for loop to add element to res, then return.
    }
}


//38ms
//28% similar idea

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	if(strs==null || strs.length == 0){
    		return new ArrayList<List<String>>();
    	}
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	for (String s:strs) {
    		char[] ca = s.toCharArray();
    		Arrays.sort(ca);
    		String keyStr = String.valueOf(ca);
    		if(!map.containsKey(keyStr))
    			map.put(keyStr, new ArrayList<String>());
    		map.get(keyStr).add(s);
    	}
    	
    	for(String key: map.keySet()) {
    		Collections.sort(map.get(key));
    	}
    	return new ArrayList<List<String>>(map.values());
    }
}
