/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

//exceed time limit
// idea is to shorten the search range list by half for each iteration...
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> res2 = new ArrayList<Integer>();
        res2.add(-1);
        res2.add(-1);
        int[] ans2 = res2.stream().mapToInt(Integer::intValue).toArray();
        if(nums==null) return ans2;
        if(nums.length==0) return ans2;
        
        int l = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        int ref = l/2;
        for(int i = 0;l / (int)(Math.pow(2,i)) > -1; i++){
            if(nums[ref] > target){
                ref = ref - l / (int)(Math.pow(2,i+2));
                continue;
            }else if(nums[ref] < target){
                ref = ref + l / (int)(Math.pow(2,i+2));
                continue;
            }else{
                if(nums[ref] == target){
                break;
                }
            }
            return ans2;
        }
        
        for(int a = 0;a<=ref;a++){
            if (nums[a]==target) {
                res.add(a);
            }
        }
        for(int b = ref;b<l;b++){
            if (nums[b]!=target) res.add(b-1);
        }
        if(res.size()==0) return ans2;
        int[] ans = res.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}

//8~9ms
//Binary search, nice implementation and recursive

public class Solution{
    public int[] searchRange(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private int[] helper(int[] nums, int target, int lo, int hi) {
        if (hi < 0) return new int[]{-1,-1};
        if (nums[lo] == target && nums[hi] == target) return new int[]{lo, hi};
        if (nums[lo] <= target && nums[hi] >= target) {
            int mid = lo + (hi - lo) / 2;
            int[] left = helper(nums, target, lo, mid);
            int[] right = helper(nums, target, mid + 1, hi);
            if (left[0] == -1) return right;
            if (right[0] == -1) return left;
            return new int[]{left[0], right[1]};
        }
        return new int[]{-1, -1};
    }
}

//8~9ms

public class Solution {
	public int[] searchRange(int[] A, int target) {
		int start = Solution.firstGreaterEqual(A, target);
		if (start == A.length || A[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target. // pretty good idea
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1); // (high-low) / 2
			//low <= mid < high
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
	}
}


//7ms
// O(logN)

public class Solution{
    public int[] searchRange(int[] A, int target) {
        int index = binarySearch(A, 0, A.length-1, target);
        int[] result = {-1, -1};
        if (index != -1) {
            int left  = index;
            int right = index;
            result[0] = left;
            result[1] = right;
            while ((left  = binarySearch(A, 0, left-1, target)) != -1)           result[0] = left;
            while ((right = binarySearch(A, right+1, A.length-1, target)) != -1) result[1] = right;
        }
        return result;
    }
    
    private int binarySearch(int[] A, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (A[mid] < target) lo = mid + 1;
            else if (A[mid] > target) hi = mid - 1;
            else return mid;            
        }
        return -1;
    }
}
