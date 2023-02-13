/*
    [1,0,2,5,4,8,2]
    [1]
    [0,0,2,0,0,0,0]
    [1,1,2,2,0]
    
    left sum of 1 is 0
    right sum of 2 is also 0
    pivot sum left = pivot sum right
    otherways return -1
    
    i should return the index of the pivot left most
    
*/
class Solution {
    public boolean isPivot(int[]nums,int pivot){
        int leftSum=0,rightSum=0;
        for(int i=0;i<pivot;i++){
            leftSum+=nums[i];
        }
        for(int i=pivot+1;i<nums.length;i++){
            rightSum+=nums[i];
        }
        return leftSum==rightSum?true:false;
    }
    public int pivotIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(isPivot(nums,i))return i;
        }
        return -1;
    }
}