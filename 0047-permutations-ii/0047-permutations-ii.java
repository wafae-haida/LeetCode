class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(), new boolean[nums.length], ans);
        return ans;
    }
    public void  backtrack(int[] nums,List<Integer> list, boolean[] visited,List<List<Integer>> ans){
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i])
                continue;
            if(i != 0 && !visited[i-1] && nums[i] == nums[i-1])
                continue;
            
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, list, visited, ans);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}