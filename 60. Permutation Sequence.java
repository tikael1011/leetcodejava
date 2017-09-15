/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/


//if n >= 13,array index overflow in java, but since the question explicitly states n is 1~9, no worry, no 'long'.

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(); 
        // During my testing, linkedlist or list does not make difference in rc, but using linkedlist does not require
        // shift after deletion.
        // In java, linkedlist is a two-step operation. First find the index, which is O(n), then delete, which is O(1).
        for (int i = 1; i <= n; i++) list.add(i);
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i; 
        // factorial
        // There is no need to use an array to store the factoril number, one is good enough.
        StringBuilder strBuilder = new StringBuilder();
        for (k--; n > 0; n--) {
            fact /= n;
            strBuilder.append(list.remove(k / fact));
            k %= fact;
        }

        return strBuilder.toString();
    }
}

/*
Solution in Python, I love 'reduce'!

//the usage of divmod() is also pretty nice, lol

def getPermutation(self, n, k):
    elements = range(1, n+1)
    NN = reduce(operator.mul, elements) # n!
    k, result = (k-1) % NN, ''
    while len(elements) > 0:
        NN = NN / len(elements)
        i, k = divmod(k, NN)
        result += str(elements.pop(i))
    return result
*/
