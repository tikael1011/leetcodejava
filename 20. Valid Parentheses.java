/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> st = new Stack();
        for(int i = 0;i<len;i++){
            if(s.charAt(i) == '(') st.push('(');
            else if(s.charAt(i) == '[') st.push('[');
            else if(s.charAt(i) =='{') st.push('{');
            else if(s.charAt(i) == ')'){
                if(st.empty()) return false;
                if(st.pop() == '(') continue;
                else return false;
            }
            else if(s.charAt(i) == ']'){
                if(st.empty()) return false;
                if(st.pop() == '[') continue;
                else return false;
            }
            else if(s.charAt(i) == '}'){
                if(st.empty()) return false;
                if(st.pop() == '{') continue;
                else return false;
            }
        }
        return (st.empty());
        
    }
}
