/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/

//3ms

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0; //0<<1 =0
        for (int i = 0; i < 32; ++i) {
            result = result<<1;
            result = result | (n & 1);  //use either "+" or "|" are the same.
            n >>>= 1;
        }
        return result;
    }
}
