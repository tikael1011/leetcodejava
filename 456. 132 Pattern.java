/*
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak 
such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as 
input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

*/

//There are at least TWO main thougts, one is utilizing the array(original input) and the other is using a stack.

//and here is how the array method envolve.

//no-brain, O(n^3) RC

public boolean find132pattern(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
            }
        }
    }
    return false;
}

//The above one can be reduce to O(n^2) and O(n), the following is O(n) rc and O(n) sc, two-pass

public boolean find132pattern(int[] nums) {
    int[] arr = Arrays.copyOf(nums, nums.length);

    for (int i = 1; i < nums.length; i++) {
        arr[i] = Math.min(nums[i - 1], arr[i - 1]);
    }
    
    for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
        if (nums[j] <= arr[j]) continue;
        while (top < nums.length && arr[top] <= arr[j]) top++;
        if (top < nums.length && nums[j] > arr[top]) return true;
        arr[--top] = nums[j];
    }
        
    return false;
}

//And here is the final O(n),one-pass and O(1) sc , three pointers. 94% ,12ms

public boolean find132pattern(int[] nums) {
    for (int n = nums.length, i = n - 1, top = n, third = Integer.MIN_VALUE; i >= 0; i--) {
        if (nums[i] < third) return true;
        while (top < n && nums[i] > nums[top]) third = nums[top++];
        nums[--top] = nums[i];
    }
    
    return false;
}

//The following one is STACK solution, O(n) rc and O(n) sc (worst case). 32ms, 54%

Stack<Integer> stack = new Stack<>(); // push aj before ai (i < j, ai < aj)
int min = Integer.MAX_VALUE;
for (int num : nums) {
    if (num <= min) {
        min = num;
    } else {
        while (!stack.empty()) {
            if (stack.peek() >= num) break;
            stack.pop();
            if (stack.pop() > num) return true;
        }
        stack.push(num);
        stack.push(min);
    }
}
return false;

//official solutions
//https://leetcode.com/articles/132-pattern/
