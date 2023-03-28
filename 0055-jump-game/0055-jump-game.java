class Solution {
    public boolean canJump(int[] nums) {
        int position = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(position <= (i + nums[i]))
                position = i;
        }
        if(position == 0)
            return true;
        return false;
    }
}