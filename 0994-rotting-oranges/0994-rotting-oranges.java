class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0,time=0;
        for(int r=0;r<grid.length;r+=1){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c]==2)
                    queue.offer(new int[]{r,c});
                else if(grid[r][c]==1)
                    fresh+=1;
            }
        }
        while(fresh!=0 && !queue.isEmpty()){
            time+=1;
            int sz=queue.size();
            for(int i=0;i<sz;i+=1){
                int[] cur=queue.poll();
                for(int[] d:dir){
                    int r=cur[0]+d[0];
                    int c=cur[1]+d[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[r].length && grid[r][c] == 1){
                        grid[r][c]=2;
                        queue.offer(new int[]{r,c});
                        fresh-=1;
                    }
                }
            }
            
        }
        return fresh==0?time:-1;
    }
}