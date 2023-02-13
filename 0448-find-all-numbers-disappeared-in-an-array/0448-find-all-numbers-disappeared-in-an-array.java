/*
    [1,2,5,6,8] ->length:n
    Values[1,n]
    mission: find the numbers in [1,n] which don't appear in nums

*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int[] dic=new int[n+1];
        for(int i=0;i<n;i++){
            int indx=nums[i];
            dic[indx]=1;
        }
        for(int i=1;i<dic.length;i++){
            if(dic[i]!=1)ans.add(i);
        }
        return ans;
    }
}