/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies. 
Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to
brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
*/


//Forget about java, forget about counting/bucket sort, waste of memory.

//We do not care about which candie the sister is given, so what we care about is ONLY the number of kinds.
// There are two main thoughts, though. One is the following:

// In Python3 , '/' will return float rather then int, so even though we know it is 'int', we use '//' instead.

def distributeCandies(self, candies):
    return min(len(candies) // 2, len(set(candies)))
    
    
//The other will make code longer, stop iteration earlier, which I would prefer during interview.

if (kinds_set.size() > total // 2):
  return total // 2
