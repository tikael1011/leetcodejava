/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh"
*/

http://stackoverflow.com/questions/1802915/java-create-a-new-string-instance-with-specified-length-and-filled-with-specif


//time limit exceed

public class Solution {
    public String reverseString(String s) {
        String res="";
        for(int i = s.length()-1; i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
}

//2ms
//what I learnt is the methond toCharArray()

public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] cs = s.toCharArray();
        int begin = 0, end = s.length() - 1;
        while(begin <= end){
            char c = cs[begin];
            cs[begin] = cs[end];
            cs[end] = c;
            begin++;
            end--;
        }
        
        return new String(cs);
    }
}

//4ms

public class Solution {
     public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}

