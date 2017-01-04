
/*
Winter is coming! Your first job during the contest is to design a standard heater with
fixed warm radius to warm all the houses.Now, you are given positions of houses and heaters
on a horizontal line, find out minimum radius of heaters so that all houses could be covered
by those heaters.So, your input will be the positions of houses and heaters seperately, 
and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
*/

//30ms
//Binarysearch doc: https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch%28int%5B%5D,%20int%29

//don't have to find the result at last ,we can get a "intermediate" result, and update it if we have to 



public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                
                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        
        return result;
    }
}


//19ms

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        
        return res;
    }
}
