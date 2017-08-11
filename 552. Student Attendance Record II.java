/*
Given a positive integer n, return the number of all possible attendance records with length n, 
which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
Note: The value of n won't exceed 100,000.
*/

//O(n) rc, O(n) sc
//the sc can be optimized to O(1), but it requires more varibles. (six I think.)

static final int M = 1000000007;

public int checkRecord(int n) {
    long[] PorL = new long[n + 1]; // ending in P or L, no A
    long[] P = new long[n + 1]; // ending in P, no A
    PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

    for (int i = 2; i <= n; i++) {
        P[i] = PorL[i - 1];
        PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
    }
    
    long res = PorL[n];
    for (int i = 0; i < n; i++) { // inserting A
    	long s = (PorL[i] * PorL[n - i - 1]) % M;
        res = (res + s) % M;
    }
    
    return (int) res;
}

//Another 'standard' DP

public int checkRecord(int n) {
    final int MOD = 1000000007;
    int[][][] f = new int[n + 1][2][3];

    f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
    for (int i = 1; i <= n; i++)
        for (int j = 0; j < 2; j++)
            for (int k = 0; k < 3; k++) {
                int val = f[i - 1][j][2]; // ...P
                if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                f[i][j][k] = val;
            }
    return f[n][1][2];
}

//the above method can be improved to O(log N)
//more detail at :https://discuss.leetcode.com/topic/86526/improving-the-runtime-from-o-n-to-o-log-n
