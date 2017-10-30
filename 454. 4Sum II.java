/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*/

//My orginal thought is backtracking/dfs...but the problem is, there is no advantage using this method.
//The second, while trivia, thought is brute force, O(N^4). To improve this, we can search a d,
//where d = -(A[i] + B[j] + C[k]), and this algorithm will achieve O(N^3). To further improve, we can search two parts
//instead, a = (A[i] + B[j]) b = - (C[k] + D[l])

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumCounter = getSumCounters(A,B);
        int fourSumCounter = 0;
        for (int c : C) {
            for (int d: D) {
                fourSumCounter += sumCounter.getOrDefault(c+d, 0);
            }
        }
        return fourSumCounter;
    }
    
    private HashMap<Integer, Integer> getSumCounters(int [] A, int [] B) {
        HashMap<Integer, Integer> sumCounter = new HashMap<>();
        for (int a : A) {
            for (int b: B) {
                int sum = -a-b;
                sumCounter.put(sum, sumCounter.getOrDefault(sum, 0) + 1);
            }
        }
        return sumCounter;
    }
}


/*
Python version

def fourSumCount(self, A, B, C, D):
    AB = collections.Counter(a+b for a in A for b in B)
    return sum(AB[-c-d] for c in C for d in D)
*/
