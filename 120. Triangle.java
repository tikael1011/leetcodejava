/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

//bottum-up DP

public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}

//one-liner Python
/*
class Solution(object):
    def minimumTotal(self, triangle):
        return reduce(lambda a, b:[min(a[i], a[i+1])+n for i, n in enumerate(b)], triangle[::-1])[0]
*/
