/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/


// O(n^2) Solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

//O(NlgN), binarysearch to find where to insert current element to an ascending array. the method is DP.

public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++; // element was added to tails, it is the current max element.
        }

        return len;
    }
}

/*
public static int binarySearch(int[] a,
               int fromIndex,
               int toIndex,
               int key)
Searches a range of the specified array of ints for the specified value using the binary search algorithm. 
The range must be sorted (as by the sort(int[], int, int) method) prior to making this call. If it is not sorted, 
the results are undefined. If the range contains multiple elements with the specified value, 
there is no guarantee which one will be found.
Parameters:
a - the array to be searched
fromIndex - the index of the first element (inclusive) to be searched
toIndex - the index of the last element (exclusive) to be searched
key - the value to be searched for
Returns:
index of the search key, if it is contained in the array within the specified range; otherwise, (-(insertion point) - 1).
The insertion point is defined as the point at which the key would be inserted into the array: 
the index of the first element in the range greater than the key, or toIndex if all elements in the range are less
than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
Throws:
IllegalArgumentException - if fromIndex > toIndex
ArrayIndexOutOfBoundsException - if fromIndex < 0 or toIndex > a.length

*/
