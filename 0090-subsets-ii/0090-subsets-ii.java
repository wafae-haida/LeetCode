class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int[] nums, int indx, List<Integer> cur, List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for(int i=indx;i<nums.length;i++){
            if(i!=indx && nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            backtrack(nums,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}