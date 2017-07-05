/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows){
      if (numRows < 0) return null;
      List<List<Integer>> ans = new ArrayList<>();
      ArrayList<Integer> dp = null;
      for (int i = 1; i<+numRows +1; i++){
        ArrayList<Integer> element = new ArrayList<>();
        for ( int j = 1 ; j <= i; j++){
          if(j == 1 || j == i) element.add(1);
          else element.add(dp.get(j-1) + dp.get(j-2));
        }
        ans.add(element);
        dp = element;
      }
      return ans;
    }
}
