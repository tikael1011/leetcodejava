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

//more elegant way

//for this one ,using swtich is faster...
public boolean isValid(String s) {
    // add if s.length is odd, return false
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}

public class Solution {
    public boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q);
        }
        return p.isEmpty();
    }
}
