/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

//becareful to deal with overflow, use LONG! and do not add "one by one", to slow

//44ms
//37.99%

public class Solution {
    public int divide(int dividend, int divisor) {
    	long result = divideLong(dividend, divisor);
    	return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    
    // It's easy to handle edge cases when
    // operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {
    	
    	// Remember the sign
    	boolean negative = dividend < 0 != divisor < 0;
    	
    	// Make dividend and divisor unsign
    	if (dividend < 0) dividend = -dividend;
    	if (divisor < 0) divisor = -divisor;
    	
    	// Return if nothing to divide
    	if (dividend < divisor) return 0;
    	
    	// Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
        	sum += sum;
        	divide += divide;
        }
        
        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
        	(divide + divideLong((dividend-sum), divisor));
    }
}


//47ms
//27.9%

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) // Trival case 1
            return dividend;
        
        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);
        
        if (dividend > divisor) // Trivial case 2
            return 0;
        
        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) // Overflow case
            return Integer.MAX_VALUE;
        
        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }
        
        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }
        
        return result;
    }
}
