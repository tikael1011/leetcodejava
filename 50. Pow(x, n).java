//implement Implement pow(x, n).
//x is double and n is int.

// the following code failed on the input (0.001, INTEGER.MAX_VALUE)   287/300 tests past.
//and is super slow...since the 'solution' can be O(lgN)
//remember to deal with special case like :(n == Integer.MIN_VALUE)

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0 && n ==0) throw new IllegalArgumentException("input undefiend");
        if(x == 0) return 0;
        if(n == 0) return 1;
        double res = x;
        double factor = x;
        if (n > 0){
            for(int i = n; i >1; i--){
                res = res * factor;
            }
            return res;
        }else{
            for(int j = -n; j >1; j--){
                res = res * factor;
            }
            return 1.0 / res;
        } 
    }
}

//23ms
//40%

public class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}

//https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers
