/*
Given a string of numbers and operators, return all possible results from computing all the different 
possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

//The basic idea is divide and conquer, divide input into N([ON]*)ON, O, N([ON]*)ON. O stands for operator
//compute result based the operator to left and right part, it is like int +-* int.
//While applying this method, there are something more to talk about. Small tricks will be just 'ignored'

//Most intuitive way, utilizing memorization, utilizing DP, the cost of substring in java is pretty bad

//#1 no optimization. 8ms

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}

//#2 morization and little trick on +-* search. 2ms

public List<Integer> diffWaysToCompute(String input) {
    //cache for memorization
    HashMap<String,List<Integer>> cache = new HashMap<String,List<Integer>>();
    return this.helper(input,cache);
}

List<Integer>helper(String s, HashMap<String,List<Integer>> cache) {
    if (cache.get(s)!=null) {
        return cache.get(s);
    }
    boolean expression = false;
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i=0; i<s.length(); i++) {
        if("+-*".indexOf(s.charAt(i))!=-1) {
            List<Integer> left = helper(s.substring(0,i),cache);
            List<Integer> right = helper(s.substring(i+1),cache);
            for(Integer l: left) {
                for(Integer r: right) {
                    result.add(cal(l,r,s.charAt(i)));
                }
            }
            expression = true;
        }
    }
    if (!expression) {
        result.add(Integer.parseInt(s));
    }
    cache.put(s, result);
    return result;
}
int cal(int l, int r, char op) {
    int result = 0;
    switch (op) {
        case '+': result= l+r; break;
        case '-': result = l-r; break;
        case '*': result= l*r; break;
        default: break;
    }
    return result;
}

//#3 DP tbc
