/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

//bottom up DP ,without array

public int numDecodings(String s) {
    if(s.length() == 0) return 0;
    int pre = 27, digit, answer = 0, first = 1, second = 1;
    for(int i = s.length()-1; i >= 0; i--){
        digit = s.charAt(i) - '0';
        if(digit == 0) answer = 0;
        else answer = first + (digit*10 + pre < 27 ? second : 0);
        second = first; first = answer; pre = digit;
    }
    return answer;
}

//use array top down

public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] = 1;
        
        for(int i = 2; i < len + 1; i ++){
            if(s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int val = Integer.valueOf(s.substring(i - 2, i));
            if(val >= 10 && val <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }
