class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0 ; r < board.length ; r++){
            for(int c = 0 ; c < board[r].length ; c++){
                if(word.charAt(0) == board[r][c]){
                    if(backtrack(board, word, r, c, 0))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int r, int c, int idx){
        if(idx == word.length())
            return true;
        if(r < 0 || r == board.length || c < 0 || c == board[r].length || board[r][c] != word.charAt(idx))
            return false;
        boolean exist = false;
        if(board[r][c] == word.charAt(idx))
            board[r][c] += 100;
        exist = backtrack(board, word, r - 1, c, idx + 1) || backtrack(board, word, r + 1, c, idx + 1) ||
            backtrack(board, word, r, c - 1, idx + 1) || backtrack(board, word, r, c + 1, idx + 1);
        board[r][c] -= 100;
        return exist;
    }
}