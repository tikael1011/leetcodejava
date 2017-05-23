/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

//O(n^n)

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;//Both used[i-1] and !used[i-1]works
                                            //!used means ascending order while used means descending.
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}


//using hashset to record duplicates

/*
Since we only need permutations of the array, the actual "content" does not change,
we could find each permutation by swapping the elements in the array.
The idea is for each recursion level, swap the current element at 1st index with 
each element that comes after it (including itself). For example, permute[1,2,3]:
At recursion level 0, current element at 1st index is 1, there are 3 possibilities:
[1] + permute[2,3], [2] + permute[1,3], [3] + permute[2,1].
Take "2+permute[1,3]" as the example at recursion level 0. At recursion level 1, 
current elemenet at 1st index is 1, there are 2 possibilities: [2,1] + permute[3], [2,3] + permute[1].
... and so on.

Let's look at another example, permute[1,2,3,4,1].
At recursion level 0, we have [1] + permute[2,3,4,1], 
[2] + permute[1,3,4,1], [3] + permute[2,1,4,1], [4] + permute[2,3,1,1], [1] + permute[2,3,4,1].
1 has already been at the 1st index of current recursion level, 
so the last possibility is redundant. We can use a hash set to mark which elements 
have been at the 1st index of current recursion level, so that if we meet the element again, we can just skip it.
*/


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0) { return ans; }
        permute(ans, nums, 0);
        return ans;
    }
    
    private void permute(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) { 
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) { temp.add(num); }
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i=index; i<nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index+1); // +1 to ensure the permutate
                swap(nums, index, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}
