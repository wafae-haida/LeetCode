class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void  backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> ans){
        if(start == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[start]);
        backtrack(nums, start + 1, cur, ans);
        cur.remove(cur.size()-1);
        backtrack(nums, start + 1, cur, ans);
    }
}