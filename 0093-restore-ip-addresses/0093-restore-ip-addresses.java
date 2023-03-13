class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s,4,"",ans);
        return ans;
    }
    public void dfs(String s, int spot, String cur, List<String> ans){
        if(s.length() > 3 * spot || s.length() < spot)
            return;
        if(spot == 1){
            if(isValid(s)){
                cur += '.' + s;
                ans.add(cur);
            }
            return;
        }
        for(int  i = 0 ;i < s.length() - (spot - 1); i++){
            String tmp = s.substring(0,i+1);
            if(isValid(tmp)){
                if(spot != 4){
                    dfs(s.substring(i+1), spot - 1,cur + '.' + tmp,ans);
                }else{
                    dfs(s.substring(i+1), spot - 1, tmp, ans);
                }
            }
        }
    }
    public boolean isValid(String tmp){
        int num = Integer.valueOf(tmp);
        if(num >= 0 && num <= 255)
            return String.valueOf(num).length() == tmp.length();
        return false;
    }
}