/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you
cannot load all elements into the memory at once?
*/

//Intersection of Two Arrays is trivia, jump to this question directly.

/*
The solution's rc is O(m + n), just counting.
for F1, can use two pointers instead, but not necessarily improve performance,
for F2, just switch num1 and nums2, use 'shorter' 'hash' .
for F3, external sort.

*/
