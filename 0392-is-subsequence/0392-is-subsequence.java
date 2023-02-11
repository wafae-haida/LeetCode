/*
 
check whither s is a subsequence of t->true or false
 
 "example"->"xe","example"


*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        for(char letter:t.toCharArray()){
            if(i<s.length() && letter==s.charAt(i))i++;
        }
        if(s.length()==i)return true;
        return false;
    }
}