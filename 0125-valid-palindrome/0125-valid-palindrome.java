/*
    uppercase->lowercase + remove all non-alphanumeric characters 
    reading forward is the same as backward
    alphanumeric(digits & english letters)
        "example258"
        "1"
        "M"
        "ex 1 xE"
         i-> <-j is it [a,z] Or [0,9] because we are taking character by character 
        "3pap3"
    target return true or false
    two pionters method
    how to define that it is a digit

*/
class Solution {
    public boolean checkPairs(char start, char end){
        if(start==end)return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-zA-Z0-9]","");
        for(int i=0,j=s.length()-1;i<s.length() && j>=0;j--,i++)
            if(!checkPairs(s.charAt(i),s.charAt(j)))return false;
        return true;
    }
}
