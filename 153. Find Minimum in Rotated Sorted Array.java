/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

*/


//It happens to be a standard binary search problem.
//if nums[mid] < nums[right], min is in the left part, and otherwise in the right part.
//simliar to 33.


class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[high]) high = mid;
            else low = mid + 1;
        }
        return nums[low];
    }
}
