/*
You are given a string representing an attendance record for a student. T
he record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/

// The solution should be at least O(n) rc
//has follow-up

//the following stupid method does not quit early, but we can simply set up a counter for A && L and thus O(1) space.
//if we meet A ,check if the counter of A is alrady 1, if yes, return fasle, otherwise counterL +1
//if we meet L, check if the counter of L is alrady 2, if yes, return flase, otherwise counterL +1
//else, reset counterL = 0, since it is continuous 'L'

public class Solution {
    public boolean checkRecord(String s) {
        int abs = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A') abs++;
            if(s.charAt(i) == 'L'){
                int temp = i;
                while((temp < s.length()) && (s.charAt(temp) == 'L')) {
                    temp++;
                    if ( (temp-i) >= 3) return false;
                }
            }
        }
        return (abs < 2);
    }
}

//one-liner
public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
}
//or
// simply return s.count('A')<2 and s.count('LLL')==0
//return !(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"));
