class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n + 1; i++)
            sum ^= i;
        
        for(int num : nums){
            sum ^= num;
        }
        
        return sum;
    }
}
