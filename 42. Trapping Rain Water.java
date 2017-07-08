/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

// two pointer solution, easy to understand and I think this is the fastest version since
//the 4 while loop escapes unnecessary  compare

public class Solution {
    public int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++; //1
        while (l < r && A[r] <= A[r - 1]) r--; //2

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) { //3
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) { //4
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
}

//less lines of code but not necessarily better code, same idea.
public class Solution {
    public int trap(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while(i <= j){
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}
