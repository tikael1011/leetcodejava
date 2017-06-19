/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

*/

//I guess this is actually medium difficulty?

/*
the key is that the answer must be in [1, n + 1].
If n numbers are 1, 2, 3, ..., n, then the answer is n + 1.
use a number x (x <= 0 || x > n) to replace a number in 1, 2, 3, ..., n. There must be a number less than n+1.
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    return i+1;
        }
        return nums.length+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
