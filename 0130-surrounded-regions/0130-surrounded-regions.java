class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        for(int c=0;c<board[0].length;c++){
            if(board[0][c]=='O')
                dfs(board,0,c);
            if(board[board.length-1][c]=='O')
                dfs(board,board.length-1,c);
        }
        
        for(int r=0;r<board.length;r++){
            if(board[r][0]=='O')
                dfs(board,r,0);
            if(board[r][board[r].length-1]=='O')
                dfs(board,r,board[r].length-1);
        }
        
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                if(board[r][c]=='O')
                     board[r][c]='X';
                if(board[r][c]=='T')
                    board[r][c]='O';
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        if(r<0 || c<0 || r==board.length || c==board[r].length || board[r][c]!='O')
            return;
        board[r][c]='T';
        for(int[] d:dir)
             dfs(board,r+d[0],c+d[1]);
    }
}