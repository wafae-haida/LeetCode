/*
        [50,10,0,40,15]
days->   1   2
    The sell day should be in the future
    
*/
class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int left=0,right=1;
        while(right<prices.length){
            if(prices[left]<prices[right]){
                ans=Math.max(ans,prices[right]-prices[left]);
                right++;
            }
            else{
                left=right;
                right++;
            }
        }
        return ans;
    }
}