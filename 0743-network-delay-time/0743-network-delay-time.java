class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] path=new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[k-1]=0;
        for(int j=0;j<n;j++){
            int[] pathcopy=Arrays.copyOf(path,n);
            for(int i=0;i<times.length;i++){
                int src=times[i][0];
                int trgt=times[i][1];
                int time=times[i][2];
                if(pathcopy[src-1]!=Integer.MAX_VALUE && pathcopy[src-1]+time<pathcopy[trgt-1])
                    pathcopy[trgt-1]=pathcopy[src-1]+time;
            }
            path=pathcopy;
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(path[i]==Integer.MAX_VALUE)return -1;
                ans=Math.max(ans,path[i]);
        }
        return ans;
    }
   
}