/*Given an array of integers, every element appears twice except for one.
Find that single one.
*/

//9ms

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2;i+=2){ // can be nums.length-1 ,but actually -2 is good enough.
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }return nums[nums.length-1];
    }
}


// use XOR operator, it is comutative!
//1 ms

public class Solution {
    int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i<nums.length; i++){
		    result ^=nums[i];
      }
      return result;
    }
}
