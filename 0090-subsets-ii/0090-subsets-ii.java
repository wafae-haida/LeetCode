class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0 , new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        
        for(int i = start ; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}