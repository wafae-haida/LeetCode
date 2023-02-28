class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] candidates, int ind, int target, List<Integer> cur, List<List<Integer>> ans){
        if(target == 0) 
            ans.add(new ArrayList<>(cur));
        else if(target < 0 || ind == candidates.length)
            return;
        else{
                cur.add(candidates[ind]);
                backtrack(candidates, ind, target - candidates[ind] , cur, ans);
                cur.remove(cur.size() - 1);
                backtrack(candidates, ind + 1, target, cur, ans); 
            
        }
    }
}