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
    public boolean isPalindrome(String s) {
      int i=0,j=s.length()-1;
        while(i<=j){
            Character start=s.charAt(i);
            Character end=s.charAt(j);
            if(!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }
            if(Character.toLowerCase(start)!=Character.toLowerCase(end))return false;
            j--;
            i++;
        }
        return true;
    }
}
