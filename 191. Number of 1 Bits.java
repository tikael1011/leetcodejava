/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has
(also known as the Hamming weight).
For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
so the function should return 3.
*/

public static int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
}
//3 ms

/***
The valve is UNSIGNED, so the following solution is WRONG
**/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int a = 0;
        if (n >= 0){
            while(n != 0){
                a = a + n % 2;
                n = n/2;
            }return a;
        }else{
            while(n != 0){
                a = a + n % 2;
                n = n/2;
            }return a-1;
        }
    }
}
