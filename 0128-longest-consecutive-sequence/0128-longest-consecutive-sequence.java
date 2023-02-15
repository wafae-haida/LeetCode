/* O(n)

    [0,2,1,8,2,3]
    ->0,1,2,3 return 4; 
    
    []->return 0
    
    [-10,2,-15,15,3]->return 0

    since the position is not important i can use a dic (set) O(n) to fill it
    now i have distinct values
    [-10,2,15,3] O(m), m<n
    
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        int ans=1;
        for(int num: nums) set.add(num);
        for(int num:nums){
            if(!set.contains(num-1)){
                int count=1;
                while(set.contains(num+1)){
                    num++;
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}