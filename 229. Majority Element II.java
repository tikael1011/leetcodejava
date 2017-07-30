/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.
*/

/*
be ware this question does not assume the majority always exists.
*/

//hashmap .utilize Map.Entry && hm.entrySet()
// or we can do a generalized version
//or the  Boyer-Moore Majority Vote algorithm for this problem, using 2 counter.

//[e]:https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html


/*
if (nums == null || nums.length == 0)
		return new ArrayList<Integer>();
	List<Integer> result = new ArrayList<Integer>();
	int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
		else if (count1 == 0) {
			number1 = nums[i];
			count1 = 1;
		} else if (count2 == 0) {
			number2 = nums[i];
			count2 = 1;
		} else {
			count1--;
			count2--;
		}
	}
	count1 = 0;
	count2 = 0;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
	}
	if (count1 > len / 3)
		result.add(number1);
	if (count2 > len / 3)
		result.add(number2);
	return result;
*/

// and I perfer Python3 though

// cand1 and cand2 should be different!

/*
def majorityElement(self, nums):
    if not nums:
        return []
    count1, count2, candidate1, candidate2 = 0, 0, 0, 1
    for n in nums:
        if n == candidate1:
            count1 += 1
        elif n == candidate2:
            count2 += 1
        elif count1 == 0:
            candidate1, count1 = n, 1
        elif count2 == 0:
            candidate2, count2 = n, 1
        else:
            count1, count2 = count1 - 1, count2 - 1
    return [n for n in (candidate1, candidate2)
                    if nums.count(n) > len(nums) // 3]
*/
