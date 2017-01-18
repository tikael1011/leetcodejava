/*
Given a positive integer n, find the least number of perfect 
square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

//DP
//72ms
public class Solution {
    public int numSquares(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}

//another DP

/**
 * s[i] denotes the least number of square numbers that add up to n
 * initial s[i] as maximum integer
 * for i from 1 to n, 
 *      if i is perfect square, s[i]=1, 
 *      otherwise get the square root of the maximum perfect square smaller than i
 * for j from 1 to square root, 
 *      if(s[i-j*j]+1<s[i]) update s[i] as s[i-j*j]+1
 * 
 * */
public int numSquares(int n) {
    int[] s = new int[n+1];
    for(int i=0;i<n+1;i++) s[i] = Integer.MAX_VALUE;
    //note to me: no need to store a list of perfect squares, knowing the square root of the largest perfect square is sufficient
    //List<Integer> squares = new ArrayList<Integer>();
    for(int i = 1;i<n+1;i++){
        int sqrt = (int) Math.sqrt(i);
        if(i == sqrt*sqrt){s[i] = 1;continue;}
        for(int j = 1;j<=sqrt;j++){
            if(s[i-j*j]+1<s[i]) s[i] = s[i-j*j]+1;
        }
    }
    return s[n];
}



//https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem
//https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
//every natural number can be represented as the sum of four integer squares.
//2 ms
//BEST!!
    public int numSquares(int n) {
        int m = n;
        while( m % 4 == 0 )
            m = m>>2;
        if(m % 8 == 7)
            return 4;
        
        int sqrtOfn = (int) Math.sqrt(n);
        if(sqrtOfn * sqrtOfn == n)//Is it a Perfect square?
            return 1;
        else{
                for(int i = 1; i <= sqrtOfn; ++i){                    //or  for (int a=0; a*a<=n; ++a) {
                    int remainder = n - i*i;                           //     int b = (int) Math.sqrt(n-a*a)
                    int sqrtOfNum = (int) Math.sqrt(remainder);       //      if (a*a + b*b ==n)
                    if(sqrtOfNum * sqrtOfNum == remainder)            //            return a==0?1:2;
                        return 2;
                }
            }
         return 3;
    }
