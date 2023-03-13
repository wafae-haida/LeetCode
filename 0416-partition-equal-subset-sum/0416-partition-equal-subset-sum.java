class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum /=2;
        Boolean[][] dp = new Boolean[nums.length][sum + 1];
        return backtrack(nums, sum, 0, dp);
    }
    public boolean backtrack(int[] nums, int sum, int start, Boolean[][] dp){
        if(sum == 0)
            return true;
        if(start >= nums.length || sum < 0)
            return false;
        if(dp[start][sum]!= null)
            return dp[start][sum];
        return dp[start][sum] = backtrack(nums, sum - nums[start], start + 1, dp) || backtrack(nums, sum, start + 1, dp);
    }
}