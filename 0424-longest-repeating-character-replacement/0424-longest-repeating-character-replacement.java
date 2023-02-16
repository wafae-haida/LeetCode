/*
"E",k=0
"EXMPLE",kmax=s.length
"EAE"
return an integer

    Solution:
        List<Character> sub;
        add [i]
        if[i]!=[i-1]curr=i-1
        add[i-1]
        k--
        k==0
        ans=Math.max(ans,sub.size())
*/
class Solution {
    public int characterReplacement(String s, int k) {
	    int[] dic=new int[26];
        int mostOc=0;
        int ans=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            dic[s.charAt(i)-'A']++;
            mostOc=Math.max(mostOc,dic[s.charAt(i)-'A']);
            if(i+1-mostOc-j>k){
                dic[s.charAt(j)-'A']--;
                j++;
            }
            ans=Math.max(ans,i+1-j);
        }
        return ans;
    }
}