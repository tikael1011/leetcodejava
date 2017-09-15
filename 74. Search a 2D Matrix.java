/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

//the following solution has potential problem: end may overflow. Still 0ms, even * / are costly. rc O(lg(mn)).
//It is O(lg(m)+lg(n)) --> O(lg(mn)). Binary search the whole matrix as a sorted list(array)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {     
        if(matrix == null || matrix.length == 0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = begin + (end - begin) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}

//while a 'safer' way is that we can search on row then into column. O(lg(mn)) as well and theoritically same speed
//but in practice, should be faster.
//Extra Testing requested.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //deal with null, {null}, {{}}
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
         
        int r=matrix.length , c=matrix[0].length,mid;
        if(target < matrix[0][0] || target > matrix[r-1][c-1]) return false;
        int s=0 , e=r-1; 
        while(s <= e){
            mid =s+ (e-s)/2;
            if (matrix[mid][c-1] == target) return true;
            else if(matrix[mid][c-1] < target) s = mid+1;
            else  e = mid-1;
        }

        int left = 0, right = c-1;
        while(left <= right){
            mid = left + (right-left)/2;
            if(matrix[s][mid] == target) return true;
            else if(matrix[s][mid] > target) right = mid-1;
            else left = mid+1;
        }
        return false; 
    }
}
