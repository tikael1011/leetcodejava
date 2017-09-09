/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned 
in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point 
drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the
optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right
room where the princess is imprisoned.
*/

//classic DP problem

//O(mn) rc, O(1) space, but the following method alters the input, if no in space requirement,
//use a 2D array instead

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        for(int i = row- 1; i >= 0; i--) {       
            for(int j = col - 1; j >= 0; j--) {
                if(i == (row - 1) && j == (col - 1)) dungeon[i][j] = Math.max(1, 1 - dungeon[i][j]); // begining
                else if(i == (row - 1)) dungeon[i][j] = Math.max(1, dungeon[i][j+1] - dungeon[i][j]);//bottum boundary
                else if(j == (col - 1)) dungeon[i][j] = Math.max(1, dungeon[i+1][j] - dungeon[i][j]);//right boundary
                else dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
            }
        }
        
    return dungeon[0][0];
    }
}

//if use extra space, we can use a [m+1][n+1] size array. this means one dummy row and one column, and we can thereby
//remove the initiate outside for loop. But this is not necessary, [m][n] can do the job.