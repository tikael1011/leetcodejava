/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/


//301ms
// WHY 301ms? Because the sqrt function is pretty expensive!!
public class Solution {
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 0;i < n; i++){
            if (isPrime(i)) res = res + 1;
        }
        return res;
    }
    
    boolean isPrime(int n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    int sqrtN = (int)Math.sqrt(n)+1;
    for(int i = 6; i <= sqrtN; i += 6) {
        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
    }
}

//32 ms

public class Solution {
    public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
       for (int i = 2; i * i < n; i++) {
          if (!isPrime[i]) continue;
          for (int j = i * i; j < n; j += i) {
             isPrime[j] = false;
          }
       }
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
       return count;
    }
}


//27ms
//by default the boolean array value is FALSE!! but the Boolean array is NULL!
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}

//22ms

public class Solution {
    public int countPrimes(int n) {
    if(n <=1 ) return 0;
    
    boolean[] notPrime = new boolean[n];        
    notPrime[0] = true; 
    notPrime[1] = true; 

    for(int i = 2; i < Math.sqrt(n); i++){
        if(!notPrime[i]){
            for(int j = 2; j*i < n; j++){
                notPrime[i*j] = true; 
            }
        }
    }
    
    int count = 0; 
    for(int i = 2; i< notPrime.length; i++){
        if(!notPrime[i]) count++;
    }
    return count; 
    }
}

//46ms
// according to https://www.youtube.com/watch?v=eKp56OLhoQs

public class Solution {
    public int countPrimes(int n) {
    if (n<=1) return 0;    
    int[] Prime = new int[n+1];
    for (int k = 0;k<n;k++) Prime[k] = 1; // no default value??
    Prime[0] = 0; 
    Prime[1] = 0; 

    for(int i = 2; i < Math.sqrt(n); i++){
        if(Prime[i] == 1){
            for(int j = 2; j*i < n; j++){
                Prime[i*j] = 0; 
            }
        }
    }
    
    int res = 0;
    for(int l: Prime){
        res = res + l;
    }
    return res;
    }
}
