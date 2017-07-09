/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

//The key is to find a way to partition the array

//there are several thoughts:
// 1. counting sort, count the number of differnt color and then rebuild them
// 2. swap based ,based on number of different color.
// 3. non-generalized version, put every '0' at front and put every '2' to the end. 


public void sortColors(int A[], int n) {
    int n0 = -1, n1 = -1, n2 = -1;
    for (int i = 0; i < n; ++i) {
        if (A[i] == 0) 
        {
            A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
        }
        else if (A[i] == 1) 
        {
            A[++n2] = 2; A[++n1] = 1;
        }
        else if (A[i] == 2) 
        {
            A[++n2] = 2;
        }
    }
}

//python no swap version

def sortColors(self, nums):
    i = j = 0
    for k in range(len(nums)):
        v = nums[k]
        nums[k] = 2
        if v < 2:
            nums[j] = 1
            j += 1
        if v == 0:
            nums[i] = 0
            i += 1

//Other intuitve method
// two pass O(m+n) space
void sortColors(int A[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;
    
    for(int i = 0; i < n; i++) {
        if (A[i] == 0) ++num0;
        else if (A[i] == 1) ++num1;
        else if (A[i] == 2) ++num2;
    }
    
    for(int i = 0; i < num0; ++i) A[i] = 0;
    for(int i = 0; i < num1; ++i) A[num0+i] = 1;
    for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
}



//more generalized version ,for N colors.

public class Solution {
    public void sortColors(int[] nums) {
        int[] cand = {0, 1, 2};
        int start=0;
        for(int i=0;i<3;i++){
            while(start<nums.length && nums[start]==cand[i]) start++;
            for(int j=start;j<nums.length;j++){
                if(nums[j]==cand[i]){
                    swap(nums, j, start++);
                }
            }
        }
        return;
    }
    public void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
