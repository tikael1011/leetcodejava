/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

//2ms
//not that list methods are pretty different from array.

List<Integer> V = new ArrayList<Integer>(rowIndex+1);
    for (int i=0; i<1+rowIndex; i++) {
        for (int j=i-1; j>=1; j--)
            V.set(j,V.get(j)+V.get(j-1));
        V.add(1);
    }
    return V;


//3ms
//add the 1st "1"

    rowIndex = rowIndex + 1;
    List<Integer> result = new ArrayList<Integer>();
    if(rowIndex <= 0) return result;
    
    for(int i = 0; i < rowIndex; i++){
        result.add(0, 1);
        //last index is reserved for 1, which we insert in the first loop
        for(int j = 1; j < result.size() -1; j++){
            //we are supposed to find j -1 and j, but we have added 0 in front so index is rightshfited
            result.set(j, result.get(j) + result.get(j+1));
        }
    }
    
    return result;
}

//5ms
//simliar to above

public List<Integer> getRow(int rowIndex) {
	List<Integer> list = new ArrayList<Integer>();
	if (rowIndex < 0)
		return list;

	for (int i = 0; i < rowIndex + 1; i++) {
		list.add(0, 1);
		for (int j = 1; j < list.size() - 1; j++) {
			list.set(j, list.get(j) + list.get(j + 1));
		}
	}
	return list;
}

//0ms
/******WHY*****/
public class Solution {
	public static List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
    	if (rowIndex >= 0)
    		list.add(1);
    	for (int i = 1, num = 1; i <= rowIndex; i++) {
    		num = (int) ((double) num / i * (rowIndex - i + 1) + 0.1);
    		list.add(num);
    	}
    	return list;
    }
}

https://en.wikipedia.org/wiki/Binomial_theorem
//1ms
//similar to above

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		Integer[] integers = new Integer[rowIndex + 1];
		integers[0] = 1;
		for (int col = 1; col <= rowIndex; col++) {
			integers[col] = (int)((long)integers[col - 1] * (rowIndex - col + 1) / col);
		}
		return Arrays.asList(integers);
	}
}
