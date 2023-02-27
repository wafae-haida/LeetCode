class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];
        Arrays.fill(paths,Integer.MAX_VALUE);
        paths[k-1]=0;
        for(int j = 0 ; j < n ; j++){
             int[] tmp = Arrays.copyOf(paths , n);
                for(int i = 0 ; i < times.length ; i++){
                    int src = times[i][0];
                    int target = times[i][1];
                    int time = times[i][2];
                    if(tmp[src - 1] != Integer.MAX_VALUE && tmp[src - 1] + time < tmp[target - 1])
                        tmp[target - 1] = tmp[src - 1] + time;
                }
            paths = tmp;
        }
        
        int rs = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(paths[i] == Integer.MAX_VALUE)
                return -1 ;
            rs = Math.max(rs , paths[i]);
        }
        return rs;
    }
}