/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

/*
If you have figured out the O(n) solution, try coding another solution
using the divide and conquer approach, which is more subtle.
*/

//14ms
//96.14%

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, smax = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum > smax) smax = sum;
            if (sum < 0) sum = 0; //reset sum to 0
        }
        return smax;
    }
}

/* the above logic can be also written in

int max = Integer.MIN_VALUE, sum = 0;
 for (int i = 0; i < A.length; i++) {
        if (sum < 0) 
            sum = A[i];
        else 
            sum += A[i];
        if (sum > max)
            max = sum;
    }
    return max;
*/

//dp
//divide problem into maxSubArray(int A[], int i) rather than
//maxSubArray(int A[], int i, int j)  why? in order to build connection between the sub and the orgin
//15ms
//78.63%

public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}



/*
DP Solution - O(n) time, O(n) space

public int maxSubArray(int[] A) {
	int dp[] = new int[A.length]; int max = A[0]; dp[0] = A[0]; 
	for (int i = 1; i < A.length; i++) {			
		dp[i] = Math.max(dp[i-1] + A[i] ,A[i]);
		max = Math.max(max, dp[i]);
	}
	return max;
}

DP Solution - O(n) time, O(1) space
//The basic idea is to check previous sum, reset it to 0 if it's less than 0.
public int maxSubArray(int[] A) {
    int res = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < A.length; i++) {
        sum = Math.max(sum, 0) + A[i];
        res = Math.max(res, sum);
    }
    return res;
} 

Pre-Sum Array Solution - O(n) time, O(n) space
//The basic idea is to use pre-sum array, max = Math.max(max, sum[i] - minSum). (minSum is the minimum sum before A[i])
public int maxSubArray(int[] A) {
	if (A == null || A.length == 0) return 0;
	int max = A[0], minSum = Integer.MAX_VALUE;
	int sum[] = new int[A.length];
	sum[0] = A[0];	
	for (int i = 1; i < A.length; i++) {
		sum[i] = sum[i-1] + A[i];
		minSum = Math.min(0, Math.min(minSum, sum[i-1]));
		max = Math.max(max, sum[i] - minSum); 
	}
	return max;
}
*/
