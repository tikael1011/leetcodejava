/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/


//7ms
//79.23%

public class Solution {
    public int strStr(String haystack, String needle) {
        if((needle.equals("")) || (haystack.equals(needle))) return 0;
        if(haystack.equals("")) return -1;
        int len = needle.length();
        int leng = haystack.length();
        for(int i = 0; i+ len<= leng; i++){
            String sub = haystack.substring(i,i+len);
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}

// what is KMP??
