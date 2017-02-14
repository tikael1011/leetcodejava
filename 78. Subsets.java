/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/**
*
*https://discuss.leetcode.com/topic/46159/
*a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
*
*/

//try same input into different method, since the result is not sorted, we can tell the internal logic.

//2ms
//28.73%
// if there is duplicate the following solution will not work

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return res;
            
        //Arrays.sort(nums);
        //init.  add empty set
        res.add(new ArrayList<>());
        
        for(int n: nums){
            int tmpsize = res.size();
            for(int i = 0; i < tmpsize; i ++){
                List<Integer> clone = new ArrayList<>(res.get(i));
                clone.add(n);         // every time a new element comes, copy the original res and add new element to
                                    // each of original element in res.
                res.add(clone);
            }
        }
        return res;
    }
}



//backtracking
//4ms
// why must be sorted??


public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}

//dfs
//either choose or not

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) { return ans; }
        Arrays.sort(nums);  // non-descending order
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans; 
    }
    
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<Integer>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }
}

