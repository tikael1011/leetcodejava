/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

You may assume k is always valid, 1 <k < n^2.

*/

//similiar to 373. Find K Pairs with Smallest Sums

/*
https://en.wikipedia.org/wiki/Median_of_medians
http://cs.geneseo.edu/~baldwin/math-thinking/saddleback.html

O(#n) here #n is the number of row/column, not element! http://www.cse.yorku.ca/~andy/pubs/X+Y.pdf
*/

//life is short python solution
/*
import heapq
class Solution(object):
    def kthSmallest(self, matrix, k):
        return list(heapq.merge(*matrix))[k-1]
*/
//life is 'a bit longer' python solution
/*
return sorted([element for row in matrix for element in row])[k-1]
*/
//life is 'longer' python solution
/*
import heapq
import itertools

return itertools.islice(heapq.merge(*matrix), k - 1, k).next()
*/


// Two main thougts:
//minheap and binary search

// KlogK, K is the kth
public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        int c = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        queue.offer(new int[] {0, 0});
        while (true) {
            int[] pair = queue.poll();
            if (++c == k) {
                return matrix[pair[0]][pair[1]];
            }
            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
                queue.offer(new int[] {0, pair[1] + 1});
            }
            if (pair[0] + 1 < matrix.length) {
                queue.offer(new int[] {pair[0] + 1, pair[1]});
            }
        }
    }
}

//search by Range instead of index ,since we cant find a way to map number && index, only in row/column
//nlogn


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
