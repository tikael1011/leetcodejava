/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))) // 696 stands for 69 and 96
                return false;
        return true;
    }
}


/*
this basic question is kinda trivia, but the follow-up ii and iii are not. I did not even intend to post solution here yet when I try to solve ii and iii, I realized I should have it written.
*/
