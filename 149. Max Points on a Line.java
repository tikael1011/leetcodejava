/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

//someone states that n will not exceed 112?

/*
Immediately I have two thoughts, the first one is brute force, like n^n
The second is transformation, (I did not remember the name 'Hough' till I googled)
*/

/* 
IMHO, the algorithm is not that complicated, but the implementation is. We can not (or maybe in the past we could?
Honestly it is literally a bad idea) use the SLOPE as hashmap key. Even if some tricks like long double, Bigdecimal,
numpy, overload operators (I did not even try one of them) can deal with the precision loss well can past all the test cases.
Instead, take the 'equation' int as key.
*/

//p1 The brute force solution, Hashmap implementation, if you realy do not like hash, still you can solve this problem
//at the cost of rc = O(n^3).

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
class Solution{
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result = 0;
        for (int i = 0; i < points.length; i++){ 
            map.clear();
            int overlap=0,max=0;
            for (int j = i + 1; j<points.length; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if ((x == 0) && (y == 0)){
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x,y);
                if (gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }   					
                }else{
                    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;


    }
    private int generateGCD(int a,int b){

        if (b == 0) return a;
        else return generateGCD(b,a % b);

    }
}


//p2 , Hough transform, we care about Rho(p), and theta(ø), but we still have the double/float problem, do we?
