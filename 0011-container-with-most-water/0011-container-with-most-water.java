/*
height[0,1,2,6,0,1]length->n
endpoints of ith line[0,[i]]

    find two height create max water container
    max left
    max right
    
    return the max amount of water can be in the container
    step2:
    formula:(i2-i1)*line
*/
class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        while(left<right){
            int area=(right-left)*Math.min(height[left],height[right]);
            ans=Math.max(ans,area);
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return ans;
    }
}