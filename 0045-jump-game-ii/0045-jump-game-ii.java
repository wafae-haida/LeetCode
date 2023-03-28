class Solution {
    public int jump(int[] nums) {
        int position = 0;
        int jump = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length - 1; i++){
            jump = Math.max(jump, i + nums[i]);
            if(i == position){
                ans++;
                position = jump;
            }
        }
        return ans;
    }
}