/*
Given a collection of intervals, find the minimum number of intervals you need to r
emove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/


//wiki:https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
//The problem is the same as 'Given a collection of intervals, 
//find the maximum number of intervals that are non-overlapping'

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;
        // using lambda exp is **** slow
        Arrays.sort(intervals, (a,b) -> a.end - b.end);
        // creat a new comparator class is a good choice actually
        /*
        class myComparator implements Comparator<Interval> {
          public int compare(Interval a, Interval b) {
              return a.end - b.end;
          }
        }
        
        and it becomes : Arrays.sort(intervals, new myComparator());
        */
        int end = intervals[0].end;
        int count = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}


// and of course we can do it directly:
/*
take one with smallest end, remove all the bad ones overlapping it,
and repeat (taking the one with smallest end of the remaining ones).
For the overlap test, just keep track of the current end, initialized with negative infinity.

def eraseOverlapIntervals(self, intervals):
    end = float('-inf')
    erased = 0
    for i in sorted(intervals, key=lambda i: i.end):
        if i.start >= end:
            end = i.end
        else:
            erased += 1
    return erased
*/
