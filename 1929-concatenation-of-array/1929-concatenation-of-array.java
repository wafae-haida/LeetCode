class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n*2];
        for(int i = 0 ; i < n; i++)
            ans[i] = nums[i];
        for(int i = n ; i < 2*n; i++){
            int m = i-n;
            ans[i] = nums[m];
        }
        return ans;
    }
}