/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

//This problem is pretty similar to 39. Combination Sum and there are two differences.
// 1. input is a collection instead of a set (may contains duplicates)
// 2. number in C may be used only ONCE

//But we can solve these two by one extra condition check ,based on previous solution:

/***

if(i > start && candi[i] == candi[i - 1]) : continue;

***/
