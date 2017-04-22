/*
Given an array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int n: nums)
                if((n >> i & 1) == 1)
                    sum++;
            sum %= 3;
            res |= sum<<i;
        }
        return res;
    }
}

// following is trick-sh*t, not extensible

public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
}
