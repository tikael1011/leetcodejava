/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

// 1/6/17.reserve


//use boolean as MASK
//pretty slow, 2.52%

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        if(board.length * board[0].length < word.length()){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean[][] check = new boolean[board.length][board[0].length];
                if(search(board, check, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean search(char[][] board,boolean[][] check, String s, int target, int row, int col){
        if(target >= s.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        if(check[row][col]){
            return false;
        }
        if(board[row][col] != s.charAt(target)){
            return false;
        }
        check[row][col] = true;
        boolean result = search(board, check, s, target + 1, row + 1, col) || search(board, check, s, target + 1, row, col + 1)
                || search(board, check, s, target + 1, row - 1, col) || search(board, check, s, target + 1, row, col - 1);
        if(result == false){
            check[row][col] = false;
        }
        return result;
    }
}




//11ms ,similar idea, 79.16ms
//use board[x][y] ^= 256 as MASK

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        } 
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
        dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
        dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
}
