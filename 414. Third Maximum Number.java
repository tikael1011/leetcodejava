/*
Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

//15ms
public class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> ref = new HashSet<Integer>();
        for(int num : nums) ref.add(num);
        Object[] ar = ref.toArray();
        Arrays.sort(ar); //I guess here is why my solution is slow
        if (ar.length<3) return (int)ar[ar.length-1];
        return (int)ar[ar.length-3];
    }
}

//20ms
//thoug the following method is slower, but the idea of 'chopping' is good somehow.
public class Solution {
  public int thirdMax(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for(int num : nums) {
      set.add(num);
      if(set.size() > 3) {
        set.remove(set.first());
      }
    }
    return set.size() < 3 ? set.last() : set.first();
  }
}

//20ms
//use priority queue

public class Solution {
    public int thirdMax(int[] nums) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       Set<Integer> set = new HashSet<>();
       for(int n : nums) {
           if(set.add(n)) {
               pq.offer(n);
               if(pq.size() > 3 ) pq.poll();
           }
       }
       if(pq.size() == 2) pq.poll();  // if(size <3){while(size >1){pq.poll();}}
       return pq.peek();
    }
}

//4ms
//best
//take "-2147483648" into consideration as well, that's why Long.MIN_VALUE instead of Integer.
//no need to sort, O(n) t-c.
public int thirdMax(int[] nums) {
    long max = Long.MIN_VALUE, mid = max, min = max;
        
    for (int ele : nums) {
        if (ele > max) {
            min = mid;
            mid = max;
            max = ele;
        } else if (max > ele && ele > mid) {
            min = mid;
            mid = ele;
        } else if (mid > ele && ele > min) {
            min = ele;
        }
    }
        
    return (int)(min != Long.MIN_VALUE ? min : max);
}
