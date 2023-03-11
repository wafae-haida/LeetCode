class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> lst = new ArrayList<>();
        int ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(lst.contains(s.charAt(i))){
                int idx = lst.indexOf(s.charAt(i));
                lst.remove(idx);
                if(idx>0)
                    lst.subList(0,idx).clear();
            }
            lst.add(s.charAt(i));
            ans = Math.max(ans, lst.size());
        }
        return ans;
    }
}