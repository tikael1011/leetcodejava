/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

//utilize XOR, and XOR is commutative

class Solution {
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}

//or use the SUM method

public int missingNumber(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++)
        sum += nums[i] - i;
    return nums.length - sum;
}

//personally I prefer the XOR solution
