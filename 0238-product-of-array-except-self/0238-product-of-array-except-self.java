/*
    [0,0,1,2,6,4,2]
    [0,0,0,0,0,0,0]
    
constaints: O(n) time, n is the length of nums

*/
class Solution {
   public int[] productExceptSelf(int[] nums) {
        int pre=1;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=pre;
            pre*=nums[i];
        }
       int post=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=post;
            post*=nums[i];
        }
       return ans;
    }
}