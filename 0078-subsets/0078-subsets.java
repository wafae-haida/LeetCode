class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,new ArrayList<Integer>(),nums,0);
        return ans;
    }
      void backTrack(List<List<Integer>> ans,List<Integer> curr,int[] nums,int start){
        ans.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            backTrack(ans,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
   
}