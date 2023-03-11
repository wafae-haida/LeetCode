class Solution {
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int r = 0 ; r < grid.length; r++){
            for(int c = 0 ; c < grid[r].length; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c){
        if( r < 0 || c < 0 || r == grid.length || c == grid[r].length || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for(int[] d : dir)
            dfs(grid, r + d[0], c + d[1]);
    }
}