/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized innums1 and nums2 are m and n respectively.
*/

//Meh
//I am not sure the purpose of this question, and in terms of 'in-space' maybe python is a better choice?
//not even C/C++, let alone java



public void merge(int A[], int m, int B[], int n) {
    int length = m+n;
    while(n > 0) A[--length] = (m == 0 || A[m-1] < B[n-1]) ? B[--n] : A[--m];
}

/*
Python version

def merge(self, nums1, m, nums2, n):
        while n > 0:
            if m <= 0 or nums2[n-1] >= nums1[m-1]:  
                nums1[m+n-1] = nums2[n-1]
                n -= 1
            else:
                nums1[m+n-1] = nums1[m-1]
                m -= 1

*/
