class Solution {
    int[] idx;
    public Solution(int[] w) {
        
        for(int i = 1 ; i < w.length; i++)
            w[i] += w[i-1];
        
        double sum = w[w.length - 1];
        double[] pb = new double[w.length]; 
        
        for(int i = 0 ; i < w.length; i++)
            pb[i] = w[i]*1000/sum;
        
        idx = new int[1000];
        int k = 0;
        for(int i = 0 ; i < w.length; i++)
            while(k<pb[i])
                idx[k++] = i;
    }
    
    public int pickIndex() {
        return idx[(int) (Math.random() * 1000)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */