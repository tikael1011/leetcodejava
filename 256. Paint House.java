/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
The cost of painting each house with a certain color is different. You have to paint all the houses such
that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost 
of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
*/


//personally I  do not like changing the input, so my solution might not
//look like that 'neat', we can simply 'copy' the original input though
//and then use the following solution
/*
public int minCost(int[][] costs) {
    if(costs==null||costs.length==0){
        return 0;
    }
    for(int i=1; i<costs.length; i++){
        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
    }
    int n = costs.length-1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
}
*/

//non-dp version

public int minCost(int[][] costs) {
    if(costs.length==0) return 0;
    int lastR = costs[0][0];
    int lastG = costs[0][1];
    int lastB = costs[0][2];
    for(int i=1; i<costs.length; i++){
        int curR = Math.min(lastG,lastB)+costs[i][0];
        int curG = Math.min(lastR,lastB)+costs[i][1];
        int curB = Math.min(lastR,lastG)+costs[i][2];
        lastR = curR;
        lastG = curG;
        lastB = curB;
    }
    return Math.min(Math.min(lastR,lastG),lastB);
}

//reduant dp

public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
        return 0;
        
    int[][] housecost=new int[costs.length+1][3];
    housecost[0][0]=0;housecost[0][1]=0;housecost[0][2]=0;
    for(int i=1;i<=costs.length;i++){
        housecost[i][0]=Math.min(housecost[i-1][1]+costs[i-1][0],housecost[i-1][2]+costs[i-1][0]);
        housecost[i][1]=Math.min(housecost[i-1][0]+costs[i-1][1],housecost[i-1][2]+costs[i-1][1]);
        housecost[i][2]=Math.min(housecost[i-1][0]+costs[i-1][2],housecost[i-1][1]+costs[i-1][2]);
        
        
        
    }
    return Math.min(Math.min(housecost[costs.length][0],housecost[costs.length][1]),housecost[costs.length][2]);
        
    }
}


//Python3
/*
def minCost3(self, costs):
    if not costs:
        return 0
    dp = costs[0]
    for i in range(1, len(costs)):
        pre = dp[:] //deep copy
        dp[0] = costs[i][0] + min(pre[1:3])
        dp[1] = costs[i][1] + min(pre[0], pre[2])
        dp[2] = costs[i][2] + min(pre[:2])
    return min(dp)

def minCost(self, costs):
    prev = [0] * 3
    for now in costs:
        prev = [now[i] + min(prev[:i] + prev[i+1:]) for i in range(3)]
    return min(prev)
    
def minCost(self, costs):
    return min(reduce(lambda (A,B,C), (a,b,c): (a+min(B,C), b+min(A,C), c+min(A,B)),
                      costs, [0]*3))
*/
