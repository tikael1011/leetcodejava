/*
There are n bulbs that are initially off. You first turn on all the bulbs.
Then, you turn off every second bulb. On the third round, you toggle every third bulb 
(turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb.
For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
*/

//MATH
//0ms,1ms
public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}


/*
We can come to the conclusion that the bulb i is toggled k times.

Here, k is the number of i's factors (except 1).

k + 1 will be the total number of i's factors

For example:

Factors of 6: 1, 2, 3, 6 (3 factors except 1, so it will be toggled 3 times)
Factors of 7: 1, 7 (1 factors except 1, so it will be toggled once)
....
Now, the key problem here is to judge whether k is even or odd.

Since all bulbs are on at the beginning, we can get:

If k is odd, the bulb will be off in the end.(after odd times of toggling).
If k is even, the bulb i will be on in the end (after even times of toggling).
As we all know, a natural number can divided by 1 and itself, and all factors appear in pairs.

When we know that p is i's factor, we are sure q = i/p is also i's factor.

If i has no factor p that makes p = i/p, k+ 1 is even.

If i has a factor p that makes p = i/p (i = p^2, i is a perfect square of p), k+ 1 is odd.

So we get that in the end:

If i is a perfect square , k+ 1 is odd, k is even (bulb i is on).
If i is NOT a perfect square , k+ 1 is even, k is odd (bulb i is off).
We want to find how many bulbs are on after n rounds (In the end).

That means we need to find out how many perfect square numbers are NO MORE than n.

The number of perfect square numbers which are no more than n, 
is the square root of the maximum perfect square number which is NO MORE than n
*/
