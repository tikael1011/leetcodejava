/*
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
*/


//name is .java, actually is Python,lol

//test cases I failed (similar): 10909091,1993.

// n^2 solution, silly... 62ms

class Solution:
    def maximumSwap(self,num):
        """
        :type num: int
        :rtype: int
        """
        arr = list(map(int, str(num)))
        for i in range(1,len(arr)):
            temp = max_d = arr[i-1]
            for j in range(i, len(arr)):            
                if arr[j] >= max_d:
                    swap = j
                    while(swap < len(arr)-1 and (arr[j] == arr[swap+1])):
                        swap += 1
                    max_d = arr[j]
            if (temp != max_d):
                arr[swap], arr[i-1] = temp,max_d
                break
        return int(''.join(map(str, arr)))
        
/*
Other solution,

Bucket sort, Which achieves O(n)

class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
}


reverse sort, O(NlgN)

public static int maximumSwap(int num) {
        String str = ""+num;
        char[] originalString = str.toCharArray();
        char[] sortedString = str.toCharArray();
        // Sort the digits in reverse order
        Arrays.sort(sortedString);
        sortedString = new StringBuilder(new String(sortedString)).reverse().toString().toCharArray();

        int i; // Find the position of mismatch between the original and sorted string
        for(i = 0; i < str.length(); i++) {
            if(originalString[i] != sortedString[i]) break;
        }

        if(i == str.length()) return num; // if no mismatch, no swap needed, return the original number
        int j = str.lastIndexOf(sortedString[i]); // find the last position of the mismatching digit in the original string

        // Interchange digits in position i and j
        char temp = originalString[i];
        originalString[i] = originalString[j];
        originalString[j] = temp;
        
        return Integer.parseInt(new String(originalString));
    }
    
And "two pointers" and so forth. and I think understanding all the above is good enough to ace the interview.
*/

// This is a weekly contest ,so no enough submission yet, so the time chart is not avaiable. and I can't do Python vs Java

//
