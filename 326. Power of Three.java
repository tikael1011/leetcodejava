/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

//27ms
//7.04%

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        int length = String.valueOf(n).length();
        if(n == Math.pow(3,2*length) || n == Math.pow(3,2*length-1)) return true; // Math.pow is pretty expensive! 
        return false;
    }
}


//19ms
// =.= 18ms will be like 90%

public boolean isPowerOfThree(int n) {
    // 1162261467 is 3^19,  3^20 is bigger than int  
    return ( n>0 &&  1162261467%n==0);
}

//https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th/2


//the following code is brilliant 

public boolean isPowerOfThree(int n) {
    return Integer.toString(n, 3).matches("10*");
}
