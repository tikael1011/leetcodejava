/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
*/

//The first stupid idea is that sort the array, then swap one by two, O(NlogN) rc for merge sort, here just omit the code

// the second one is one-pass compare and sort

public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            // odd swap nums[i] < nums[i - 1] or even swap nums[i] > nums[i - 1]
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}

/*
def wiggleSort(self, nums):
    for i in range(len(nums)):
        nums[i:i+2] = sorted(nums[i:i+2], reverse=i%2
*/
