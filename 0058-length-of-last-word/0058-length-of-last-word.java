/*
T:O(s)
S:O(1)
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int ans=0;
        int edgeSpace=s.length()-1;
        while(s.charAt(edgeSpace)==' '){
            s=s.substring(0,edgeSpace);
            edgeSpace--;
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')break;
            ++ans;
        }
        return ans;
    }
}