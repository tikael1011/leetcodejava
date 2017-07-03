/*
There are a number of spherical balloons spread in two-dimensional space. 
For each balloon, provided input is the start and end coordinates of the horizontal diameter.
Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
Start is always smaller than end. There will be at most 10^4 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis.
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6])
and another arrow at x = 11 (bursting the other two balloons).
*/


//find the right way to sort and use 'end' position instead of start position can save one 'if' branch

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points == null) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        // sort for the end, and every arrow will shoot at current ballon[1]
        int arrowPos = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            ans++;
            arrowPos = points[i][1];
        }
        return ans;
    }
}
