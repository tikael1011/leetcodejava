/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/


//the worst case will be O(n), because if A[mid] == A[start] == A[end] then we have to move either
//end or start by one step. and this case may end up with a O(n), while the original question will end up with
// O(logN)--Binary Search

//general version

public boolean search(int[] A, int target) {
    int start = 0;
    int end = A.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;// since start <= end holds, actually we can write (s+e)/2.
        if (A[mid] == target) // case 0
            return true;
        // finally start == mid == end, if case 0, return true, else end the loop
        else if (A[start] == A[mid])
            start++;
        else if (A[end] == A[mid])
            end--;
        else if (A[start] <= target && target <= A[mid]) // case 1
            end = mid;
        else if (A[mid] < target && target <= A[end]) // case 2
            start = mid + 1;
        else if (A[start] > A[mid]) // case 2 is false, so target in this range
            end = mid;
        else   // case A[mid] > A[end] and case 1 is false, similar to above
            start = mid + 1;
    }
    return false;
}

// improved version (same rc)
public boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        // System.out.format("start=%d,mid=%d,end=%d\n",start,mid,end);
        if (nums[mid] == target) return true;
        
        // need to handle: 1,3,1,1,1
        while (nums[start] == nums[mid] && start != mid) {
            start ++;
        }
        while (nums[mid] == nums[end] && mid != end) {
            end --;
        }

        // the following is the same as problem I
        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    
    return false;
}
