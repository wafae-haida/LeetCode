public class Solution {
    public int findMin(int[] num) {
        int left=0,right=num.length-1;
        while(left<=right){
            if(num[right]>=num[left])
                return num[left];
            int mid=(left+right)/2;
            if(num[mid]>=num[left])
                left=mid+1;
            else
                right=mid;
        }
        return 0;
    }
}