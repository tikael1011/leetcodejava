'''
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
'''

# I promise one will NEVER see the kind of easy problem during an interview. and you can tell this from 
# so many downvotes. This just reminds me the usage of bisect

def guessNumber(self, n):
    class C: __getitem__ = lambda _, i: -guess(i)
    return bisect.bisect(C(), -1, 1, n)
    
def guessNumber(self, n):
    lo, hi = 1, n
    while lo < hi:
        mid = (lo + hi) / 2
        lo, hi = ((mid, mid), (mid+1, hi), (lo, mid-1))[guess(mid)]
    return lo
