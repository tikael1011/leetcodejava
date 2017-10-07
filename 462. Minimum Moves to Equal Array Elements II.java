/*
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/

//The idea is to find the median of the array, and immediately a sort solution comes to my mind
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0, mid = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            res += i > mid ? nums[i] - nums[mid] : nums[mid] - nums[i];
        }
        return res;
    }
}

//but the above solution is O(nlgn) rc and O(nlgn) sc, and we do not care about the sorted order, we care about
//the median only, so we can use quick selesct / median of median to achieve AVERAGE O(n) rc. worst case is O(n^2)

public int minMoves2(int[] A) {
    int sum = 0, median = quickselect(A, A.length/2+1, 0, A.length-1);
    for (int i=0;i<A.length;i++) sum += Math.abs(A[i] - median);
    return sum;
}

public int quickselect(int[] A, int k, int start, int end) {
    int l = start, r = end, pivot = A[(l+r)/2];
    while (l<=r) {
        while (A[l] < pivot) l++;
        while (A[r] > pivot) r--;
        if (l>=r) break;
        swap(A, l++, r--);
    }
    if (l-start+1 > k) return quickselect(A, k, start, l-1);
    if (l-start+1 == k && l==r) return A[l];
    return quickselect(A, k-r+start-1, r+1, end);
}

public void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
