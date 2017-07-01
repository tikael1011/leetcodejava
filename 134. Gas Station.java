/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

//O(n), O(1)

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int start=gas.length, end=0, sum=0;
      do sum+= sum>0? gas[end]-cost[end++]: gas[--start]-cost[start]; while (start!=end);
      return sum>=0? start: -1;
    }
}

//or python

/*
def canCompleteCircuit(self, gas, cost):
        gas_left = gas_needed = start = 0
        for i, (g, c) in enumerate(zip(gas, cost)):
            gas_left += g - c
            if gas_left < 0:
                gas_needed -= gas_left
                start = i + 1
                gas_left = 0
        return start if gas_left >= gas_needed else -1
*/
