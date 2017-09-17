/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.


*/


//Take advange of the input is always valid, and non-negative integers, otherwise problem will become crazy, IMO
//And now the problem becomes how to deal with () and '-'. My original though is to cal everything inside () recursively,
//to achieve this
//1.find the first ')' after '('
//2.expand backwards to cal a full (), store to result, take sign into consideration
//3.repeat 1 ,2 for the substring(indexof('(')) until the whole string.
//Then I realize this algorithm is horrible, (1). the implementation is complex; (2). even if we have a prefect to solve (1)
//in worst case, the rc increases exponentially.


//While use a stack to keep track of result and sign or sign only before the () is a better choice, or, right one.


class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}





/*
def calculate(self, s):
    total = 0
    i, signs = 0, [1, 1]
    while i < len(s):
        c = s[i]
        if c.isdigit():
            start = i
            while i < len(s) and s[i].isdigit():
                i += 1
            total += signs.pop() * int(s[start:i])
            continue
        if c in '+-(':
            signs += signs[-1] * (1, -1)[c == '-'],
        elif c == ')':
            signs.pop()
        i += 1
    return total
*/
