/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
*/

//before write code, try to understand the question and write the string then n = 5,6...

/*
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211
*/

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int outer = 1; outer < n; outer++) {
            String previous = result;
            result = "";
            int count = 1;
            char say = previous.charAt(0);

            for (int i = 1; i < previous.length(); i++) {
                if (previous.charAt(i) != say) {
                    result = result + count + say;
                    count = 1;
                    say = previous.charAt(i);
                } else count++;
            }
            result = result + count + say;
        }
        return result;
    }
}

//way faster solition:
//I think the main reason is because of string '+'

public class Solution {
    public String countAndSay(int n) {
        String ret = ""+1;
        
        while(--n  > 0)
            ret = apply(ret);
        
        return ret;
    }
    
    String apply(String s){
        StringBuilder ret = new StringBuilder();
        
        for(int i = 0, count =0; i  < s.length() ; ){
            while(i + count < s.length() && s.charAt(i) == s.charAt(i + count))
                count ++;
                    
            ret.append(count).append(s.charAt(i));
            i += count; 
            count = 0;
        }
        
        return ret.toString();
    }
}
