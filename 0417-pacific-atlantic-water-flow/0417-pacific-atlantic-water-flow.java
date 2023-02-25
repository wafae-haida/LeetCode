class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int rL=heights.length;
        int cL=heights[0].length;
        boolean[][] pacificOcean= new boolean[rL][cL];
        boolean[][] atlanticOcean= new boolean[rL][cL];
        for(int i=0;i<rL;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacificOcean);
            dfs(heights,i,cL-1,Integer.MIN_VALUE,atlanticOcean);
        }
        for(int j=0;j<cL;j++){
            dfs(heights,0,j,Integer.MIN_VALUE,pacificOcean);
            dfs(heights,rL-1,j,Integer.MIN_VALUE,atlanticOcean); 
        }
        for(int i=0;i<rL;i++){
            for(int j=0;j<cL;j++){
                if(pacificOcean[i][j] && atlanticOcean[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void dfs(int[][] heights,int r,int c,int preVal,boolean[][] ocean){
        if(c<0 || r<0 || r==heights.length || c==heights[r].length || preVal>heights[r][c]
           ||ocean[r][c])
            return;
        ocean[r][c]=true;
        dfs(heights,r,c+1,heights[r][c],ocean);
        dfs(heights,r,c-1,heights[r][c],ocean);
        dfs(heights,r-1,c,heights[r][c],ocean);
        dfs(heights,r+1,c,heights[r][c],ocean);
    }
}