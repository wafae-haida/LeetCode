class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int count = 0, right = nums.length - 1;
        for(int left = nums.length/2 - 1; left >= 0 ; left--){
            if(nums[left] * 2 <= nums[right]){
                count += 2;
                right--;
            }
        }
        return count;
    }
}