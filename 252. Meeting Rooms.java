/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings. 
For example, Given [[0, 30],[5, 10],[15, 20]], return false.
*/

//comparator 

public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
 
    for(int i=0; i<intervals.length-1; i++){
        if(intervals[i][1]>intervals[i+1][0]){
            return false;
        }
    }
 
    return true;
}

//above is the my understaning, but actually the input is not a 2D array,but Interval
//public boolean canAttendMeetings(Interval[] intervals) 
/*
And in terms of comparator, there is another smart way to accomplish this.

https://discuss.leetcode.com/topic/20959/ac-clean-java-solution/2

This implementation can save some time (if the answer is false ,since it avoid extra sort and the O(n)) theoretically

But is reality, it depends
*/
