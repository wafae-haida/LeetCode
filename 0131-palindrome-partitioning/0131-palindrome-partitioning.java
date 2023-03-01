class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0, ans);
        return ans;
    }
    public void backtrack(String s, List<String> list, int start, List<List<String>> ans){
        if(start == s.length())
            ans.add(new ArrayList<>(list));
        for(int i = start; i < s.length(); i++){
            String cur = s.substring(start, i + 1);
            if(isPalindrom(cur)){
                list.add(cur);
                backtrack(s, list, i + 1, ans);
                list.remove(list.size() - 1);
            }
        }  

    }
    public boolean isPalindrom(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--))
                return false;  
        }
        return true;
    } 
}