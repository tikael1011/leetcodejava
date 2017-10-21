/*
Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
*/

//This is a variant of the classic dp problem (72. edit distance)

//and there are at least two dp thoughts, one is the find the LCS(longest common subsequence) and the other
//is bottom-up dp, calcuate the cost(ans) directly, which is almost the same from No.72.

//Thought No.1 43.86%

def minDistance(self, w1, w2):
      m, n = len(w1), len(w2)
      dp = [[0] * (n + 1) for i in range(m + 1)]
      for i in range(m):
          for j in range(n):
              dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j], dp[i][j] + (w1[i] == w2[j]))
      return m + n - 2 * dp[m][n]
      
      
//Thought Np.2 75%

class Solution(object):
    def minDistance(self, A, B):
        M, N = len(A), len(B)
        dp = [[0] * (N+1) for _ in range(M+1)]

        for i in range(M):
            dp[i][-1] = M-i
        for j in xrange(N):
            dp[-1][j] = N-j

        for i in range(M-1, -1, -1):
            for j in range(N-1, -1, -1):
                if A[i] == B[j]:
                    dp[i][j] = dp[i+1][j+1]
                else:
                    dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1])

        return dp[0][0]
        
        

