/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/

//13ms
//8.48%
public class Solution {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int num: nums){
            if(num != val) nums[res++] = num;
        }
        return res;
    }
}

//use TWO pointer can be faster

public class Solution {
        public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0 ; i< len; ++i){
            while (A[i]==elem && i< len) {
                A[i]=A[--len]; //'chop' and check the last element
            }
        }
        return len;
    }
}


//even better

public class Solution {
    public int removeElement(int[] A, int elem) {
        int l = A.length;
        for (int i=0; i<l; i++) {
            if (A[i] == elem) {
                A[i--] = A[l-- -1];
            }
        }
        return l;
    }
}
