/*
Given an array S of n integers, are there elements a, b, c 
in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/


public List<List<Integer>> threeSum(int[] nums) {
    
    List<List<Integer>> result = new ArrayList<>();
    
	int n = nums.length;
	if(n < 3) return result;
	
	Arrays.sort(nums);
	
	int i = 0;
	
	while(i < n - 2)
	{
		int start = i + 1, end = n - 1;
		while(start < end)
		{
			int sum = nums[i] + nums[start] + nums[end];
			if(sum == 0)
			{
				result.add(Arrays.asList(nums[i], nums[start], nums[end]));
				do
				{
					end--;
				}while(end > start && nums[end] == nums[end + 1]);
				do
				{
					start++;
				}while(start < end && nums[start] == nums[start - 1]);
			}
			else if(sum > 0)
			{
				do
				{
					end--;
				}while(end > start && nums[end] == nums[end + 1]);
			}
			else
			{
				do
				{
					start++;
				}while(start < end && nums[start] == nums[start - 1]);
			}
		}
		do
		{
			i++;
		}while(i < n - 2 && nums[i] == nums[i - 1]);
	}
	
	return result;
}

///


public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }
        int j = i + 1, k = nums.length - 1;  
        int target = -nums[i];
        while (j < k) {
            if (nums[j] + nums[k] == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            } else if (nums[j] + nums[k] > target) {
                k--;
            } else {
                j++;
            }
        }
    }
    return res;
}
