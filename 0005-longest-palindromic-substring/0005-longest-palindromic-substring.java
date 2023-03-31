class Solution {
    public String longestPalindrome(String s) {
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = "";
            for(int j = s.length() ; j > i ; j--){
                String tmp = s.substring(i, j);
                if(isPalindrome(tmp)){
                    palindrome = tmp;
                    break;
                }                    
            }
            if(rs.length() < palindrome.length())
                rs = palindrome;
        }
        return rs;
    }

    public boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}