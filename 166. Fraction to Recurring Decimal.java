/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

//4ms
//40.78%

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder str = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            str.append('-');
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long n = num/den;
        long reminder = num % den;
        str.append(n);
        if (reminder == 0) return str.toString();
        else str.append('.');
        while(!map.containsKey(reminder)) {
            map.put(reminder,str.length());
            n = reminder*10/den;
            reminder = reminder*10%den;
            if (reminder != 0 || reminder == 0 && !map.containsKey(reminder)) {
                str.append(n);
            }
        }
        if (reminder != 0) {
            str.insert(map.get(reminder),"(");
            str.append(')');            
        }
        return str.toString();
    }
}
