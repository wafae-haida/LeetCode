class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        bcaktrack(digits,map,0, new StringBuilder(), res);
        return res;
    }
    public void bcaktrack(String digits, String[] map,int start, StringBuilder cur, List<String> res){
        if(start == digits.length()){
            res.add(cur.toString());
            return;
        }
        for(char c : map[digits.charAt(start) - '0'].toCharArray()){
            cur.append(c);
            bcaktrack(digits,map,start + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}