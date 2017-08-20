/*
Given a m x n grid filled with non-negative numbers, find a path 
from top left to bottom right which minimizes the sum of all numbers along its path
*/

//classis dp prolem
//again, is altering allowed/good? if so, O(1) space, otherwise O(n) space.

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
            if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
            if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
