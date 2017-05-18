/*
Determine whether an integer is a palindrome. Do this without extra space.
*/


//RC O(n),SC O(1)

public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
        	rev = rev*10 + x%10;
        	x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0 || x%10 == 0) {
            return false;
        }
        
        int r = 0;
        while(r < x) {
            int e = x % 10;
            x = x / 10;
            if (r == x) {
                return true;
            }
            r = r * 10;
            r = r + e;
        }
        return (r == x);
    }
}
