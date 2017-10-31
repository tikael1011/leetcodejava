/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
*/

//The idea is simple, O(n) scan. 

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<nums.length;) {
            int start = i;
            while(i+1<nums.length&&nums[i+1]-nums[i]==1) {
                i++;
            }
            if(nums[i]>nums[start]) {
                ans.add(nums[start]+"->"+nums[i]);
            }else if(nums[i]==nums[start]) {
                ans.add(""+nums[i]);
            }
            i++;
        }
        return ans;
    }
}
