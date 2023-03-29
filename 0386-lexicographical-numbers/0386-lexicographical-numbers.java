class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, n, 1);
        return ans;
    }
    
    private void dfs(List<Integer> ans, int n, int start) {
        if (start > n) return; 
        ans.add(start); 
        dfs(ans, n, 10*start);
        if (start % 10 < 9) { 
            dfs(ans, n, start + 1); 
        }
    }
}