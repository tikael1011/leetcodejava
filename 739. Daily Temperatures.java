/*
Given a list of daily temperatures, produce a list that, for each day in the input, 
tells you how many days you would have to wait until a warmer temperature. 
If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000].
Each temperature will be an integer in the range [30, 100].
*/

//stack solution, O(n) rc and O(sc), this one is similar to 'next generate number'

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx; // res[idx] instead of res[i] !!! this ensures O(n) rc and '0'
            }
            st.push(i);
        }
        return res;
    }
}

// while a hashmap is also applicable. Yet there is another algorithm which takes O(n * K) rc, where K is the
//temperatures range, and since the range is relative small, no need to worry about hash collision.
