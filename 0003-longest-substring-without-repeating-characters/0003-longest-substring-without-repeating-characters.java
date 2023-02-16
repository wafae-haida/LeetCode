/*
"exampleexample"
""
"example"
"152++"
"ex145*4"
"++-*"
"EXAM  pLE"
 
 Target: return the longest distinct substring

*/
class Solution {

    public int lengthOfLongestSubstring(String s) {
        List<Character> sub = new ArrayList<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(sub.contains(s.charAt(i))){
                int indx=sub.indexOf(s.charAt(i));
                sub.remove(indx);
                if(indx>0){
                    sub.subList(0,indx).clear();
                }
            }
            sub.add(s.charAt(i));
            ans=Math.max(ans,sub.size());
        }
        return ans;
    }
}

