/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/

//There are two basic thougts, one is split() then count the array lenght, of which rc O(n) and sc O(n) as well,
//the other one is to count the segment directly by checking current 'char', of which rc O(n) and sc O(1).

//thought 1

class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}

//thought 2
public class Solution {
    public int countSegments(String s) {
        int counter = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')) {
                counter++;
            }
        }
        return counter;
    }
}
