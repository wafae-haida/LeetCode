/*

    loop over the matrix to find:
    0 near of 1 or bounds ->++
    for each grid we check 4 trends
    we check only the grids that contains 1s
    1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1=16
    
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(j-1>=0 ){
                  if(grid[i][j-1]==0 && grid[i][j]==1)ans++;
                }else if(j-1<0 && grid[i][j]==1){
                    ans++;
                }   
                if(j+1<grid[i].length){
                    if(grid[i][j+1]==0 && grid[i][j]==1)ans++;
                }else if(j+1>=grid[i].length && grid[i][j]==1){
                    ans++;
                }
                if(i+1<grid.length){
                    if(grid[i+1][j]==0 && grid[i][j]==1)ans++;
                }else if(i+1>=grid.length && grid[i][j]==1){
                    ans++;
                }
                if(i-1>=0){
                    if(grid[i-1][j]==0 && grid[i][j]==1)ans++;
                }else if(i-1<0 && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}