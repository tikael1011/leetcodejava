/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

// Eevn without the hint, one should notice the rc is O(logN), binary search.

/*
class Solution(object):
    def findPeakElement(self, nums):
        left = 0
        right = len(nums)-1
        while left < right-1:
            mid = (left+right)/2
            if nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                return mid

            if nums[mid] < nums[mid+1]:
                left = mid+1
            else:
                right = mid-1
        return left if nums[left] >= nums[right] else right
*/

public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}