/*
Given an array of integers, find out whether there are two distinct indices i and j 
in the array such that the absolute difference between nums[i] and nums[j] is at most
t and the absolute difference between i and j is at most k.
*/

/*
This is an interesting question, I mean the first idea come to my mind is to create a pair class，store index
and the array value and then compare code is like the following

public class ValuePosPair implements Comparable<ValuePosPair>{    //maybe not public? since we have only "One" file.

	int val;
	int pos;

	ValuePosPair(int v, int p) { val = v; pos = p;}

	public int compareTo(ValuePosPair x){
		return this.val - x.val;
	}	
}
................................................................

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	if(nums.length<2||k<1||t<0) return false;
	ValuePosPair[] valPosArr = new ValuePosPair[nums.length];
	for(int i =0;i<nums.length;i++) valPosArr[i] = new ValuePosPair(nums[i],i); 
	Arrays.sort(valPosArr);	
	for(int i=0;i<valPosArr.length;i++){
		for(int j=i+1;j<valPosArr.length&&((long)valPosArr[j].val-(long)valPosArr[i].val<=(long)t);j++){
			if(Math.abs(valPosArr[j].pos-valPosArr[i].pos)<=k) return true;	
		}
	}
	return false;
}  
*/


/*
While the other ideas are using bucket sort or construct a BST
BS results in O(n) rc and O(n) sc.
BST results in O(NlgK) rc and O(n) sc.

I am wondering is there a 'better' solution.

TBC
*/
