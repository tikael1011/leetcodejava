/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/


// This solution is wrong at [1,2] k =1 ,but in my eclipse it has the right output???
// 2/17 add for(int i = 0; i < len; i++) nums[i] = res.get(i); !!!
//7ms...***slow

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(k<=0 || k == len) return;
        List<Integer> res = new ArrayList<>();
        for(int i = k; i>0; i--){
            res.add(nums[len-i]);
        }
        for(int j = 0; j < len-k; j++){
            res.add(nums[j]);
        }
    }
}

//'traditional' way
//1 ms ,there is 0 ms

public class Solution {
    public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
