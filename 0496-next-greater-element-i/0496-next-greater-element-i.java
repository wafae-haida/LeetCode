/*
nums2[0,1,2,6,8,10]->original
nums1[1,0,2,8,2,6]

since the nums2 is sorted
binary search O(logn)

*/
class Solution {
    public int search(int[] nums,int i){
        for(int n=0; n<nums.length; n++){
            if(nums[n]==i){
                for(int j=n+1; j<nums.length; j++){
                    if(nums[j]>i)
                        return nums[j];
                }
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       for(int i=0;i<nums1.length;i++){
           nums1[i]=search(nums2,nums1[i]);
       }
        return nums1;
    }
}