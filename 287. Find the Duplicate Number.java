/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

//IMO, there is no need to worry about the NlogN ,'binary search' problem since we can
//come up with a O(n), circle detection algorithm.

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //find index
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        //find number
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
