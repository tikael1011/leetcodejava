/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

//similar to 33 & 81, follow-up question allows duplicates.

// still , worst case O(n), best O(1), avg(lgN).

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int start = 0, end = nums.length - 1;
        while (nums[end] == nums[start] && end > start) {
            end--;
        }
        
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return nums[start];
    }
}
