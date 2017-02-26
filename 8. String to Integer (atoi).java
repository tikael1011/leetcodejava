/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below and ask yourself what are the possible input cases.
*/

//gege, toooooo many cases not reasonable, like 10e5 ? -+1 ? ask more if in the interview meet this
//49ms
//30%

public class Solution {
    public int myAtoi(String str) {
        int i = 0;
        str = str.trim();        
        char[] c = str.toCharArray();
        
        int sign = 1;
        if (i < c.length && (c[i] == '-' || c[i] == '+')) {
            if (c[i] == '-') {
                sign = -1;
            }
            i++;
        }      
        
        int num = 0;
        int bound = Integer.MAX_VALUE / 10;
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            if (num > bound || (num == bound && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
}
