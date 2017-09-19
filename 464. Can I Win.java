/*
In the "100 game," two players take turns adding, to a running total,
any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of 
numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal,
determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
*/

/*
Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
*/

//https://discuss.leetcode.com/category/593/can-i-win

public class Solution {
    Map<Integer, Boolean> set[];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if(maxChoosableInteger+1 >=desiredTotal) return false;
        set = new Map[301];
        for(int i  =0 ;i<301;i++) set[i] = new HashMap<>();
        if(maxChoosableInteger*(maxChoosableInteger+1)/2 < desiredTotal) return false;
        return canWin((1<<maxChoosableInteger+1)-1, desiredTotal);
    }
    
    public boolean canWin(int set1, int total){
        if(set[total].containsKey(set1)) return set[total].get(set1);
        for(int i = 20;i>=1;i--){
            int p = (1<<i);
            if((p&set1) == p){
                int set1next = (set1^p);
                int totalNext = total - i;
                if(totalNext<=0) return true;
                boolean x;
                if(set[totalNext].containsKey(set1next)) x = set[totalNext].get(set1next);
                else x = canWin(set1next, totalNext);
                if(!x){
                    set[total].put(set1, true);
                    return true;
                }
            }
        }
        set[total].put(set1, false);
        return false;
    }
}
