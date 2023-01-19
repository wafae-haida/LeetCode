class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dFS(grid,i,j);
                    ans++;
                }
            }
        }
        return  ans;
    }
        
    public void dFS(char grid[][], int i, int j){
        if( i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0')return;
        grid[i][j]='0';
        dFS(grid,i,j-1);
        dFS(grid,i,j+1);
        dFS(grid,i-1,j);
        dFS(grid,i+1,j);
    }
}

