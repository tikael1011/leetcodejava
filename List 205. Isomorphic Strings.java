/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.


*/

//REALLY SLOW && BAD O(N*N) WHY?    49ms
// because containsValue() is O(n)



public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> hm = new HashMap<>();
        Map<Character,Character> mh = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int sl = s.length();
        int tl = t.length();
        if(sl != tl) return false;
        for(int i =0;i<sl;i++){
            if(hm.containsKey(sc[i])){
                if(tc[i] != hm.get(sc[i])){
                    return false;
                }
            }
            hm.put(sc[i],tc[i]);
            if(mh.containsKey(tc[i])){
                if(sc[i] != mh.get(tc[i])){
                    return false;
                }
            }
            mh.put(tc[i],sc[i]);
        }
        return true;
    }
  
  /* one hashmap but same logic
  
  public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }
}
  
 */
 
  
 // 7ms ,use array only
  
  public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	int[] map = new int[128];
    	int[] book = new int[128];
    	for (int i = 0; i < s.length(); i++) {
    		int cs = (int) s.charAt(i);
    		int ts = (int) t.charAt(i);
    		if (map[cs] == 0 && book[ts] == 0) {
    			map[cs] = ts;
    			book[ts] = 1;
    		} else if (map[cs] != ts)
    			return false;
    	}
    	return true;
    }
}
  
