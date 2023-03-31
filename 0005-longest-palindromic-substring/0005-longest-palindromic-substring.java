class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longestPalindrome = "";
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i <= 2 || dp[i+1][j-1]);
                if (dp[i][j] && j-i+1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j+1);
                }
            }
        }
        return longestPalindrome;
    }
}
