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

/**
more than 4 methods , dfs, backtracking, avoid set, dp
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



/*
The main idea reminds an approach for solving coins/knapsack
problem - to store the result for all i < target and create the solution from them.
For that for each t from 1 to our target we try every candidate which is 
less or equal to t in ascending order. For each candidate "c" we run through all 
combinations for target t-c starting with the value greater or equal than c to 
avoid duplicates and store only ordered combinations.
*/
//32ms
//17%


public class Solution {
    public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}
