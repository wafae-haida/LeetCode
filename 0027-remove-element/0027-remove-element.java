/*
[1,0,25,3,6],6


*/
class Solution {
    public void swap(int[] nums,int cur,int end){
        int tmp=nums[cur];
        nums[cur]=nums[end];
        nums[end]=tmp;
    }
    public int removeElement(int[] nums, int val) {
        int k=0,j=nums.length-1;
        while(k<=j){
            if(nums[k]==val){
                swap(nums,k,j);
                j--;
            }else{
                k++;
            }
            }
        return k;
        }
    }
