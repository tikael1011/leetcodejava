/*
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could
operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, 
with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
*/


//one python idea: https://discuss.leetcode.com/topic/104018/short-python/7

//[java float division zero] https://goo.gl/zZfU7P

class Solution {
    public boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});
    }
    
    private boolean f(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0] - 24)<0.01;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }
}
