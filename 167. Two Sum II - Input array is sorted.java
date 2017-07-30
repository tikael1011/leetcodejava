/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up
to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

//using hashmap will still work but takes O(n) space and does not take advange of sorted

//binary search O(NlgN) rc O(1) sc

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
     // Assume input is already sorted.
     for (int i = 0; i < numbers.length; i++) {
     int j = bsearch(numbers, target - numbers[i], i+1); // it is i+1, not i. i fails on test case [0,0,1,2],0.
     if (j != -1) {
     return new int[] { i + 1, j + 1 };
     }
     }
     throw new IllegalArgumentException("No two sum solution");
    }
    private int bsearch(int[] A, int key, int start) {
     int L = start, R = A.length - 1;
     while (L < R) {
         int M = (L + R) / 2;
         if (A[M] < key) {
         L = M + 1;
         } else {
         R = M;
         }
     }
     return (L == R && A[L] == key) ? L : -1;
    }
}

//two pointers O(n) rc O(1) sc
//there are 3 basic cases

public int[] twoSum(int[] numbers, int target) {
 int i = 0, j = numbers.length - 1;
 while (i < j) {
   int sum = numbers[i] + numbers[j];
     if (sum < target) {
     i++;
     } else if (sum > target) {
     j--;
   } else {
   return new int[] { i + 1, j + 1 };
   }
 }
 return null
}
