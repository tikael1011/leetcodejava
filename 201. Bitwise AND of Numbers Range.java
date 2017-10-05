/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/


//this one is from left to right
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for (; m != n; ++i) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
}

//the other thinking

 public int rangeBitwiseAnd(int m, int n) {
        while(m<n) n = n & (n-1);
        return n;
    }
