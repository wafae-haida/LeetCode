class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0,end = 0, ans = Integer.MAX_VALUE, sum = 0;
        while(end < nums.length){
            sum += nums[end++];
            while(target <= sum){
                ans = Math.min(ans, end - start);
                sum -= nums[start++];
            }
        }
        return ans != Integer.MAX_VALUE? ans:0;
    }
}