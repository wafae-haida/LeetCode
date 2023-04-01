class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    boolean helper(char[][] board)
    {
        for(int row=0; row<board.length; row++)
        {
            for(int col=0; col<board.length; col++)
            {
                if(board[row][col]=='.')
                {
                    for(int val=1; val<=9; val++)
                    {
                        if(isSafe(row,col,(char)(val+'0'),board))
                        {
                            char c = (char)(val+'0');
                            board[row][col] = c;
                          
                            boolean temp = helper(board);
                            if(temp)  
                                return true;
                            else{   
                                board[row][col] = '.';
                            }
                        }
                    }
                 
                       return false;
                }
            }
        }
        return true;
    }
    boolean isSafe(int row,int col,char val,char[][] board)
    {
        for(int i=0; i<board.length; i++)
        {
            if(board[row][i]==val)
                return false;
          
            if(board[i][col]==val)
                return false;
          
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==val)
                return false;
        }
        return true;
    }
}