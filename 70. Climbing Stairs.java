
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/


public int climbStaris(int n){
  int p =1;
  int q = 1;
  for(int i = 2; i<= n; i++){
    int temp = q;
    q += p;
    p = temp;
    }
    return q;
}

//O(n) RC, O(1) SC
