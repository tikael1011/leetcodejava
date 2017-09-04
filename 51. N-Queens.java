/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/


//Three hashset solution, keep track of two diagonals and column , 20 %

public class Solution {
    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            
            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            dfs(res, list, row + 1, n);
            
            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}

// While use three arrays instead of three hashset, speed up dramatically, 94%, WHY???

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<1)
            return result;
        solve(result, new ArrayList<String>(), n, 0,new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }
    public void solve(List<List<String>> result, List<String> cur,
                      int n, int rowCur, boolean[] col, boolean[] diag1, 
                      boolean[] diag2){
        if(rowCur==n){
            result.add(new ArrayList<String>(cur));
            return;
        }
        for(int j = 0; j<n; j++){
            int d1=rowCur+j;
            int d2=j-rowCur+n-1;
             if(!col[j] && !diag1[d1] && !diag2[d2]){
                    col[j]=true;
                    diag1[d1]=true;
                    diag2[d2]=true;
                    char[] helpChars=new char[n];
                    Arrays.fill(helpChars,'.');
                    helpChars[j]='Q';
                    cur.add(new String(helpChars));
                    
                    solve(result, cur, n, rowCur+1, col, diag1, diag2);
                    
                    col[j]=false;
                    diag1[d1]=false;
                    diag2[d2]=false;
                    cur.remove(cur.size()-1);
                }
        }
    }
}

/*
I guess the reason is that, Hashset does achieve O(1) contains search, while for arraylist it is O(n).
But what we did here is DIRECTLY access an element/value, and Hashset is about 2~3 or more time slower in
iteration than an array (because it costs like 5.5 tims of memonry?)
*/

//Below is the Python solution, we can easily 'read' even write, but it is hard to translate into Java or other
//language

/*
def solveNQueens(self, n):
    def DFS(queens, xy_dif, xy_sum):
        p = len(queens)
        if p==n:
            result.append(queens)
            return None
        for q in range(n):
            if q not in queens and p-q not in xy_dif and p+q not in xy_sum: 
                DFS(queens+[q], xy_dif+[p-q], xy_sum+[p+q])  
    result = []
    DFS([],[],[])
    return [ ["."*i + "Q" + "."*(n-i-1) for i in sol] for sol in result]
*/
