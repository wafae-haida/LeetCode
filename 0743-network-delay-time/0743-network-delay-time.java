class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] path=new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[k-1]=0;
        for(int j=0;j<n;j++){
            for(int i=0;i<times.length;i++){
                int src=times[i][0];
                int trgt=times[i][1];
                int time=times[i][2];
                if(path[src-1]!=Integer.MAX_VALUE && path[src-1]+time<path[trgt-1])
                    path[trgt-1]=path[src-1]+time;
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(path[i]==Integer.MAX_VALUE)return -1;
                ans=Math.max(ans,path[i]);
        }
        return ans;
    }
   
}