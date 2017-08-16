/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/


// My original understanding is that if there is a zero, then the whole matrix become zero, but actually
// the 'zero' does not backtrack. The problem requires O(1) space, which means we can not use a list/array
// of which length is (m+n) to store the position of zeros, we need another method.
//the idea is to use first column and first row to record zeros, and then set first column/row to zeros accordingly.

public void setZeroes(int[][] matrix) {
    if(matrix==null || matrix.length==0){
        return;
    }
    
    boolean setFirstRowToZeroes = false;
    boolean setFirstColumnToZeroes = false;
    
    //check if first column needs to be set to zero
    for(int row=0;row<matrix.length;row++){
        if(matrix[row][0] == 0){
            setFirstColumnToZeroes=true;
            break;
        }
    }
    
    //check if first row needs to be set to zero
    for(int col=0;col<matrix[0].length;col++){
        if(matrix[0][col] == 0){
            setFirstRowToZeroes=true;
            break;
        }
    }
    
    //mark columns and rows to be set to zero
    for(int row=1;row<matrix.length;row++){
        for(int col=1;col<matrix[0].length;col++){
            if(matrix[row][col]==0){
                matrix[row][0]=0;
                matrix[0][col]=0;
            }
        }
    }
    
    // make rows zero
    for(int row=1;row<matrix.length;row++){
        if(matrix[row][0]==0){
            for(int col=1;col<matrix[0].length;col++){
                matrix[row][col]=0;
            }
        }
    }
    
    // make columns zero
    for(int col=1;col<matrix[0].length;col++){
        if(matrix[0][col]==0){
            for(int row=1;row<matrix.length;row++){
                matrix[row][col]=0;
            }
        }
    }
    
    // zero out first row (if needed)
    if(setFirstRowToZeroes){
        for(int col=0;col<matrix[0].length;col++){
            matrix[0][col]=0;
        }
    }
    
    // zero out first column (if needed)
    if(setFirstColumnToZeroes){
        for(int row=0;row<matrix.length;row++){
            matrix[row][0]=0;
        }
    }
    
}
