/*
from No.26

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being
1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i <2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}


//extend version up to duplicate at most K times

public int removeDuplicates(int[] nums, int k) {
    int i = 0;
    for (int n : nums)
        if (i < k || n > nums[i-k])
            nums[i++] = n;
    return i;
}
