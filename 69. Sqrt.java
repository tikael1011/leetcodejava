//
//Implement int sqrt(int x).
//Compute and return the square root of x.

/**
https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
**/

//most straightfoward way
//but slowest way maybe
// 21ms 4.57%

public class Solution {
    public int mySqrt(int x) {
        long i = 0;
        while(i * i <= x){
            i++;
        }
        return (int)((i-1 < 0)?0:i-1);
    }
}

//..even slower
//GOOD JOB
//30ms 3.xx%

public class Solution {
    public int mySqrt(int x) {
        long i = 1;
        long min = 0;
        while(min<x){
            i++;
            min = min + ((2 * i) -1);
        }
        return (int)((i-1 < 0)?0:i-1);
    }
}

//binary search
//3ms

public class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x, ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

//newton's method
//2ms

public class Solution {
    public int mySqrt(int x) {
       long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}

//https://discuss.leetcode.com/topic/2671/share-my-o-log-n-solution-using-bit-manipulation
//best, bit manipulation
