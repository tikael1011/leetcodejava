/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/


//46ms
//32.19%

public class Solution {
    public int reverse(int x) {
        boolean flag = (x<0)? true:false;
        x = (x>0)?x:-x;
        int length = String.valueOf(x).length();
        String ref = Integer.toString(x);
        String roof = Integer.toString(Integer.MAX_VALUE);
        if(length >10) return 0;
        int res = 0;
        boolean pass = false;
        if(length ==10){
            for(int i = length-1;i>=0;i--){
                if(Character.getNumericValue(ref.charAt(i)) > Character.getNumericValue(roof.charAt(length-i-1))){
                    if(pass==false) return 0;
                }else if(Character.getNumericValue(ref.charAt(i)) == Character.getNumericValue(roof.charAt(length-i-1))){
                    pass = false;
                    continue;
                }
                pass = true;
            }
        }
        for(int i = length-1;i>=0;i--){
            res = res + Character.getNumericValue(ref.charAt(i)) * (int)Math.pow(10,i);
        }
        if(res > Integer.MAX_VALUE) return 0;
        return flag?-res:res;
    }
}

//way better than mine
//37ms
//89.63%
//but this take advantage of Long and int so the next solution is better.

public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x%10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int)result;
    }
}

// in my opinion, the formal solution

public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
