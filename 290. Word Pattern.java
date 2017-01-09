/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

//4ms
// My original thought...looks so slow

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] match = str.split("\\s+");
        int pl = pattern.length();
        if ( pl!= match.length) return false;
        for (int i = 0; i<pl;i++){
            match[i] = String.valueOf(pattern.charAt(i)) + match[i];
        }
        Arrays.sort(match);
        for(int j = 0;j<pl-1;j++){
            if(match[j].charAt(0) == (match[j+1].charAt(0))){
                if(match[j].substring(1).equals(match[j+1].substring(1))){
                    continue;
                }else{
                    return false;
                }
            }else{
                if((match[j].substring(1).equals(match[j+1].substring(1)))){
                    return false;
                }
            }continue;
        }
        return true;
    }
}


//3ms
//more comments check next solution

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }    
        }
        return true;
    }
}

//2ms
//use two hashmap, which is faster than use one,becasue it avoids to use "map.containsKey(c)", of which time complexity is
//O(n), see above method
// the following has further improvement, use a hashset instead of a second hashmap.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
         String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        
        HashMap<Character, String> hm1 = new HashMap<Character, String>();
        HashMap<String, Character> hm2 = new HashMap<String, Character>();
        for(int i=0; i<pattern.length(); ++i) {
            if(hm1.containsKey(pattern.charAt(i))) {
                if(!hm1.get(pattern.charAt(i)).equals(strs[i])) return false;
            }
            else {
                if(hm2.containsKey(strs[i])) return false;
                else {
                    hm1.put(pattern.charAt(i), strs[i]);
                    hm2.put(strs[i], pattern.charAt(i));
                }
            }
        }
        
        return true;
    }
}


/* The other's work
//2ms as well. manipulate Set.add also returns a boolean and Map.put returns 
the previous value associated with key,or null if there was no mapping for key. 
public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
}
I go through the pattern letters and words in parallel and compare the indexes where they last appeared.

Edit 1: Originally I compared the first indexes where they appeared, using putIfAbsent instead of put.
That was based on mathsam's solution for the old Isomorphic Strings problem. But then czonzhu's answer
below made me realize that put works as well and why.

Edit 2: Switched from

    for (int i=0; i<words.length; ++i)
        if (!Objects.equals(index.put(pattern.charAt(i), i),
                            index.put(words[i], i)))
            return false;
to the current version with i being an Integer object, which allows to compare with just != because
there's no autoboxing-same-value-to-different-objects-problem anymore. Thanks to lap_218 for somewhat
pointing that out in the comments.
*/
