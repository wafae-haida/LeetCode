//T O(m*n), S O(rs)->rs length of the result
class Solution {
     public String longestCommonPrefix(String[] strs) {
       StringBuilder rs= new StringBuilder();
         for(int i=0;i<strs[0].length();i++){
             for(String c:strs){
                 if(i==c.length() || c.charAt(i)!=strs[0].charAt(i))return rs.toString();
             }
             rs.append(strs[0].charAt(i));
         }
         return rs.toString();
    }
}