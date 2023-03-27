class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, res, new StringBuilder());
        return res;
    }
    void backtrack(int n, int open, int close, List<String> res, StringBuilder cur){
        if(cur.length() == n*2){
            res.add(cur.toString());
            return;
        }
        if(open<n){
            cur.append("(");
            backtrack(n, open + 1, close, res, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){
            cur.append(")");
            backtrack(n, open, close + 1, res, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}