class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(nums,ans,new ArrayList<Integer>(),0);
        return ans;
    }
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> cur,int start){
        if(cur.size()==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<=cur.size();i++){
            cur.add(i,nums[start]);
            backtrack(nums,ans,cur,start+1);
            cur.remove(i);
        }
    }
}