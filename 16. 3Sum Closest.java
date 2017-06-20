/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

//Very similar to the 3 Sum problem and we can do this in O(n^2) and (sadly)O(n) space.
//Each time compare the difference between sum and target, if it is less than minimum difference so far,
//then replace result with it, otherwise keep iterating.

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length <= 3) {
            int tmp = 0; 
            for (int i: num) {
                tmp += i;
            }
            return tmp;
        }
        int result = num[0] + num[1] + num[num.length - 1];// toy result
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {// still we can skip dpulicates here
                    end--;
                } else if (sum < target){// still we can skip dpulicates here
                    start++;
                }else{
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}

