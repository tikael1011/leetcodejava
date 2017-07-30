/*
Given an array of size n, find the majority element. The majority element is the element
that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.


*/

/*
ideas:

sort, hashmap, bit manipulation  and Moore voting
*/

//moore voting, which has O(n) rc. should be the fastest solution

public int majorityElement(int[] nums) {
    int count=0, ret = 0;
    for (int num: nums) {
        if (count==0)
            ret = num;
        if (num!=ret)
            count--;
        else
            count++;
    }
    return ret;
}

//if you choose the use sorting ,take care the array has only one elemet
