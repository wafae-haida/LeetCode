class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        String ans = "";
        System.out.print(s.substring(0,i));
        while(i>=0){
            while(i>=0 && s.charAt(i) == ' ') i--;
            int j = i + 1;
            if(i < 0) break;
            while(i>=0 && s.charAt(i) != ' ') i--;
            if(ans.isEmpty())
                ans = ans.concat(s.substring(i+1,j));
            else
                ans = ans.concat(' ' + s.substring(i+1,j));
        }
        return ans;
    }
}