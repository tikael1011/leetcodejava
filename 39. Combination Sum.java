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

//triditional backtracking
//30ms, 23%

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> solution = new ArrayList<List<Integer>>();
		List<Integer> curSolution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backTrack(solution, curSolution,candidates, target, 0); 
		return solution;
	}

	private void backTrack(List<List<Integer>> solution,List<Integer> curSolution,int[] candidates, int target, int lastIdx) {
		if (target == 0) {
			solution.add(new ArrayList<>(curSolution));
		}
		else if (target < 0) {
			return;
		}
		else {
			int i = lastIdx;
			while (i < candidates.length) {
				int candidate = candidates[i];
				curSolution.add(candidate);
				backTrack(solution,curSolution,candidates, target - candidate, i);
				curSolution.remove(curSolution.size() - 1);
				while (i < candidates.length && candidates[i] == candidate) {
					i++;
				}
			}
		}
    }
}


//avoid using set

//21ms  75%

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Arrays.sort(candidates); // sort the candidates
    // collect possible candidates from small to large to eliminate duplicates,
    recurse(new ArrayList<Integer>(), target, candidates, 0, ret);
    return ret;
}

// the index here means we are allowed to choose candidates from that index
private void recurse(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> ret) {
    if (target == 0) {
        ret.add(list);
        return;
    }
    for (int i = index; i < candidates.length; i++) {
        int newTarget = target - candidates[i];
        if (newTarget >= 0) {
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(candidates[i]);
            recurse(copy, newTarget, candidates, i, ret);
        } else {
            break;
        }
    }
}
