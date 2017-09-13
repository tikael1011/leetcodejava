/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

//catalan number

//G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
//F(i, n) = G(i-1) * G(n-i)   --> G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)

//DP

public int numTrees(int n) {
    int [] G = new int[n+1];
    G[0] = G[1] = 1;
    
    for(int i=2; i<=n; ++i) {
    	for(int j=1; j<=i; ++j) {
    		G[i] += G[j-1] * G[i-j];
    	}
    }

    return G[n];
}

//Math, the following code works in C, not JAVA, did not test in Python yet
int numTrees(int n) {
    //cantalan tree
    //C(2n,n)/(n+1)
    long long ans =1;
    for(int i=n+1;i<=2*n;i++){
        ans = ans*i/(i-n);
    }
    return ans/(n+1);
}
