/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

// I tested both string concat && string builder, unfortunately SB is slower, but we should still use sb,
// shouldn't we?

class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder res = new StringBuilder();
        res.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]);
        return res.toString();
    }
}
