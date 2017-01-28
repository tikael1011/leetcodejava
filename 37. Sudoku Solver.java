
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
// input ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
// output ["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]

//23ms
//66.13%

public class Solution {
    private char[][] b;
    public void solveSudoku(char[][] board) {
        if(board == null || board.length < 9) return;
        b = board;
        solve(0);
    }
    public boolean solve(int ind){
        if(ind==81) return true; 
        int i=ind/9, j=ind%9;
        if(b[i][j]!='.') return solve(ind+1);
        else{
            for(char f = '1'; f <= '9'; f++){
                if(isValidFill(i, j, f)){
                    b[i][j]= f;
                    if(solve(ind+1)) return true;    // important step, check weather the last filled number             
                    b[i][j]='.';                    // fulfill all the borad, if not , reset the last filled number to '.' 
                }                                   // then increase the number and do the whole staff again.
            }
            return false;
        }
    }
    public boolean isValidFill(int i, int j, char fill){
        for(int k=0; k<9; k++){
            int r= i/3*3+j/3;   //select the block
            if(b[i][k]==fill || b[k][j]==fill || b[r/3*3+k/3][r%3*3+k%3]==fill) 
                return false; //check row, column, block
        }            
        return true;
    }
}
