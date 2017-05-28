/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

//using reverse order can make things easier and faster
//everytime make a copy of the orignal with the left element

//23ms, 61%

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new LinkedList<Integer>(),candidates,target);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, LinkedList<Integer> list, int[] arr, int target){
        if(target == 0){
            result.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = arr.length -1; i>=0;i--){
            if(arr[i] <= target){
                list.addFirst(arr[i]);
                dfs(result,list,Arrays.copyOfRange(arr,0,i+1),target - arr[i]);
                list.removeFirst();
            }
        }
    }
}
