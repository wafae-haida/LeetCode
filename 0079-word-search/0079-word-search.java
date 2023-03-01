class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0 ; r < board.length ; r++){
             for(int c = 0 ; c < board[r].length ; c++){
                if(backtrack(board, word, 0, r, c))
                    return true;
             }
         }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int indx, int r, int c){
        if(indx == word.length())
            return true;
        if(r < 0 || c < 0 || r == board.length || c == board[r].length || board[r][c] != word.charAt(indx))
            return false;
        boolean exist = false;
        if(board[r][c] == word.charAt(indx))
            board[r][c] += 100;
        exist = backtrack(board, word, indx + 1, r + 1, c)
        || backtrack(board, word, indx + 1, r - 1, c)
        || backtrack(board, word, indx + 1, r, c + 1)
        || backtrack(board, word, indx + 1, r, c - 1);
        board[r][c] -= 100;
        return exist;
    }
}