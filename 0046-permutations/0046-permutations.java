class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans);
        return ans;
    }
    public void dfs(int[] nums, int start,List<List<Integer>> ans){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            ans.add(new ArrayList<>(list));
        }
        for(int i = start ; i < nums.length; i++){
            swap(nums,start,i);
            dfs(nums, start + 1, ans);
            swap(nums,start,i);
        }
    }
    public void swap(int[] nums, int start, int i){
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;
    }
}