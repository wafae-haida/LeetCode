class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, res, new StringBuilder());
        return res;
    }
    void backtrack(int n, int open, int close, List<String> res, StringBuilder strSoFar){
        if(strSoFar.length() == n*2){
            res.add(strSoFar.toString());
            return;
        }
        if(open<n){
            strSoFar.append("(");
            backtrack(n, open+1, close, res, strSoFar);
            strSoFar.deleteCharAt(strSoFar.length()-1);
        }
        if(close < open){
            strSoFar.append(")");
            backtrack(n, open, close+1, res, strSoFar);
            strSoFar.deleteCharAt(strSoFar.length()-1);
        }
        System.out.println(strSoFar);
    }
}