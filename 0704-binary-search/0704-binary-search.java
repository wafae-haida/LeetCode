class Solution{
    
    int search(int[] nums, int target){
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=end+((start-end)/2);
            if(nums[mid]==target)return mid; 
            if(nums[mid]<target)
                start=mid+1;
            if(nums[mid]>target)end=mid-1;
        }
        return -1;
    } 
    
}