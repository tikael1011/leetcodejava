/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinehelper(res, new ArrayList<Integer>(), 1,n,k);
        return res;
    }
    
    private void combinehelper(List<List<Integer>> res, List<Integer> cb, int start, int n, int k){
        if (k == 0){
            res.add(new ArrayList<Integer>(cb));
            return;
        }
        for (int i = start; i <= n-k+1 ;i++){ // was i <= n, but we can stop early
            cb.add(i);
            combinehelper(res, cb, i+1, n, k-1);
            cb.remove(cb.size()-1);
            //System.out.println(comb);
        }
    }
}
//take combine(10, 3) as example, the result will be:
/*
[1,2,3]
[1,2,4]
...
[1,2,10]
[1,3,4]
...
[2,3,4]
...
[8,9,10]
*/


/There are several Python short line answers/
/*
not necessarily fast O(n*k)

from itertools import combinations

class Solution:
    def combine(self, n, k):
        return list(combinations(range(1, n+1), k))
        
class Solution:
    def combine(self, n, k):
        if k == 0:
            return [[]]
        return [pre + [i] for i in range(1, n+1) for pre in self.combine(i-1, k-1)]
*/
