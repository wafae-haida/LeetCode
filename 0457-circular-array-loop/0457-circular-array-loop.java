class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            boolean isForword = nums[i]>=0;
            int fast = i, slow = i;
            do{
                slow = findNextIndex(nums,isForword,slow);
                fast = findNextIndex(nums,isForword,fast);
                if(fast != -1)
                    fast = findNextIndex(nums,isForword,fast);
            }while(fast != -1 && slow != -1 && fast!=slow);
            if(fast != -1 && fast == slow)
                return true;
        }
        return false;
    }
    public int findNextIndex(int[] nums, boolean isForword, int idx){
        boolean direction = nums[idx] >= 0;
        int res = 0;
        if(direction != isForword)
            return -1;
        res = (nums[idx] + idx) % nums.length;
        if(res < 0)
            res += nums.length;
        if(res == idx)
            return -1;
        return res;
    }
}