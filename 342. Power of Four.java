/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

public boolean isPowerOfFour(int num) {
    return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
}
//0x55555555 == 1431655765 == 0b1010101010101010101010101010101 
//or use (num % 3 == 1) instead
/*
public class Solution {
    public boolean isPowerOfFour(int n) {
        return (n % 3 == 1) && ((n & n-1) == 0);
    }
}
*/
