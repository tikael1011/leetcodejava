
/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/

// similar to unique path, the bottom-up dp

class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length;
        int n = obs[0].length;
        int[][] mat = new int[m+1][n+1];
        mat[m-1][n] = 1;
        for(int r = m - 1; r >= 0; r--){
            for(int s = n - 1; s >= 0; s--){
                mat[r][s] = (obs[r][s] == 1)? 0 : mat[r][s+1] + mat[r+1][s];  
            }
        }
      return mat[0][0];
    }
}
