/*
iterate over the grid
seek out for 1s->i ll recursively check the four directions seecking for:
                                                                            ->0s or edges
                                                                            Also i ll keep track of the numbers of 1s in each area
                                                                            i ll take the mux of them
 i ll use BFS
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0 && grid[0].length==0) return 0;
        int ans=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c]==1)
                {
                    ans=Math.max(countArea(grid,r,c,new int[]{0}), ans);
                }
                  
            }
        }
        return ans;
    }
    int countArea(int[][] grid, int r, int c, int[] count){
        if(r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c]==0) return count[0];
        count[0]++;
        grid[r][c]=0;
        countArea(grid, r, c+1,count);
        countArea(grid, r, c-1,count);
        countArea(grid, r-1, c,count);
        countArea(grid, r+1, c,count);
        return count[0];
    }
    
}