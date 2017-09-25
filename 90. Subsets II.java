/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

//iterative

public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	result.add(new ArrayList<Integer>());
	int begin = 0;
	for(int i = 0; i < nums.length; i++){
		if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
		int size = result.size();
		for(int j = begin; j < size; j++){
			List<Integer> cur = new ArrayList<Integer>(result.get(j));
			cur.add(nums[i]);
			result.add(cur);
		}
		begin = size;
	}
	return result;
}

//DFS, recursive.

public List<List<Integer>> subsetsWithDup(int[] nums) {
   List<List<Integer>> result = new ArrayList<List<Integer>>();

    if(nums.length == 0){
        return result;
    }

    Arrays.sort(nums);
    dfs(nums, 0, new ArrayList<Integer>(), result);
    return result; 
}

public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result){
    result.add(new ArrayList<Integer>(path));

    for(int i = index; i < nums.length; i++){
        if(i>index&&nums[i]==nums[i-1]) continue; // deal with duplicates
        path.add(nums[i]);
        dfs(nums, i+1, path, result);
        path.remove(path.size()-1);
    }
}

/*
Python:
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        res = [[]]
        S.sort()
        for i in range(len(S)):
            if i == 0 or S[i] != S[i - 1]:
                l = len(res)
            for j in range(len(res) - l, len(res)):
                res.append(res[j] + [S[i]])
        return res


*/
