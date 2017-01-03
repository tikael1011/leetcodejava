/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

//8ms

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        if(list == null || list.length == 0) return 0;
        return list[list.length-1].length();
    }
}

//5ms

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;  
        }
        int len = s.length();
       int count = 0;  
       for (int i = len - 1; i >= 0; i--) {  
           if (s.charAt(i) != ' ') {  
               count++;  
           }  
           if(s.charAt(i)==' '&&count != 0){  
               return count;  
           }  
       }  
       return count; 
    }
}
