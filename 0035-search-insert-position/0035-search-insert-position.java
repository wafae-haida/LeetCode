class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1,mid=end+((start-end)/2);
        while(start<=end){
            if(nums[mid]<target)start=mid+1;
            else if(nums[mid]>target)end=mid-1;
            else return mid;
            mid=end+((start-end)/2);
        }
        return mid+1;
    }
}