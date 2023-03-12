class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0 ; i <= n; i++){
            ans[i] = count_ones(i);
        }
        return ans;
    }
    public int count_ones(int i){
        int count = 0;
        while(i != 0){
            if(i%2 == 1)
                count++;
            i/=2;
        }
        return count;
    }
}